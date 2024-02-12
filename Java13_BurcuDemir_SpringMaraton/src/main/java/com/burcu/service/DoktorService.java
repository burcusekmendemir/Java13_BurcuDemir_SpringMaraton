package com.burcu.service;

import com.burcu.dto.request.DoktorSaveRequestDto;
import com.burcu.dto.response.DoktorStatusResponseDto;
import com.burcu.dto.response.RandevuStatusResponseDto;
import com.burcu.entity.Brans;
import com.burcu.entity.Doktor;
import com.burcu.entity.Randevu;
import com.burcu.exception.DoktorRandevuAppException;
import com.burcu.exception.ErrorType;
import com.burcu.mapper.BransMapper;
import com.burcu.mapper.DoktorMapper;
import com.burcu.repository.DoktorRepository;
import com.burcu.repository.RandevuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoktorService {

    private final DoktorRepository doktorRepository;
    private final BransService bransService;
    private final RandevuRepository randevuRepository;

    /**
     * Hastanenin doktor tanımlayabilmesi sağlayan methodtur.
     * Bu method içinde aynı zamanda brans kaydı da yapılır, bransService katmanındaki save
     * methoduna gidildiğinde gerekli kontroller orada yapılmaktadır.
     *
     * Doktorun adına göre sisteme yapılan kayıtların kontrolünü yapmaktadır, eğer sistemde
     * aynı isimle kayıtlı doktor varsa hata fırlatır, yoksa da yeni bir doktor nesnesi yaratır.
     * @param dto
     * @return
     */
    public Doktor save(DoktorSaveRequestDto dto) {
        Brans brans=bransService.save(BransMapper.INSTANCE.fromDoktorDtoToBransDto(dto));
        Optional<Doktor> optionalDoktor=doktorRepository.findByDoktorAdi(dto.getDoktorAdi());
        if (optionalDoktor.isPresent()){
            throw new DoktorRandevuAppException(ErrorType.DOCTOR_ALREADY_EXISTS);
        }
        Doktor doktor= DoktorMapper.INSTANCE.fromDoktorSaveRequestDtoToDoktor(dto);
        doktor.setBransId(brans.getId());
        return doktorRepository.save(doktor);

    }

    /**
     * Sistemde kayıtlı tüm doktorları getirir.
     * @return
     */
    public List<Doktor> findAll() {
        return doktorRepository.findAll();
    }


    /**
     * Doktorun bilgilerinin güncellenmesini sağlar. Geri dönüş tipi olarak sisteme
     * güncellenmiş doktoru kaydeder.
     * @param updateDoktor
     * @return
     */
    public Doktor update(Doktor updateDoktor) {
        Doktor existingDoktor=doktorRepository.findById(updateDoktor.getId())
                .orElseThrow(() -> new DoktorRandevuAppException(ErrorType.DOCTOR_NOT_FOUND));

        existingDoktor.setDoktorAdi(updateDoktor.getDoktorAdi());
        existingDoktor.setBransId(updateDoktor.getBransId());
        existingDoktor.setDoktorStatus(updateDoktor.getDoktorStatus());
        existingDoktor.setUnvan(updateDoktor.getUnvan());

        return doktorRepository.save(existingDoktor);
    }

    /**
     * İd numarasına göre sistemde kayıtlı doktor var ise doktoru döndürür.
     * Eğer yoksa doktorun bulunamadığının hatasını fırlatır.
     * @param doktorId
     * @return
     */

    public Optional<Doktor> findById(Long doktorId) {
        Optional<Doktor> optionalDoktor=doktorRepository.findById(doktorId);
        if (optionalDoktor.isPresent()){
            return optionalDoktor;
        }
        throw  new DoktorRandevuAppException(ErrorType.DOCTOR_NOT_FOUND);
    }


    /**
     * Hastanenin doktorların durumlarını ve hangi gün kiminle randevularının olduğunu döndüren methodtur.
     * mapToDoktorStatusResponseDto methodu ile hangi gün kimlerin randevularının
     * olduğu liste olarak döndürülür.
     * @return
     */
    public List<DoktorStatusResponseDto> findAllDoktorByStatus(){
        List<Doktor> doktors=doktorRepository.findAllByOrderByDoktorStatusDesc();
        return doktors.stream()
                .map(this::mapToDoktorStatusResponseDto)
                .collect(Collectors.toList());
    }
    public DoktorStatusResponseDto mapToDoktorStatusResponseDto(Doktor doktor){
        List<Randevu> randevuList= randevuRepository.findAllByDoktorId(doktor.getId());
        List<RandevuStatusResponseDto> randevuStatusList= randevuList.stream()
                .map(randevu -> RandevuStatusResponseDto.builder()
                        .hastaAdi(randevu.getHastaAdi())
                        .tarih(randevu.getTarih())
                        .saat(randevu.getSaat())
                        .randevuStatus(randevu.getStatus())
                        .build())
                .collect(Collectors.toList());

        return DoktorStatusResponseDto.builder()
                .id(doktor.getId())
                .doktorAdi(doktor.getDoktorAdi())
                .doktorStatus(doktor.getDoktorStatus())
                .randevuList(randevuStatusList)
                .build();
    }

}
