package com.burcu.service;

import com.burcu.dto.request.RandevuSaveRequestDto;
import com.burcu.dto.response.RandevuSaveResponseDto;
import com.burcu.entity.Doktor;
import com.burcu.entity.Randevu;
import com.burcu.exception.DoktorRandevuAppException;
import com.burcu.exception.ErrorType;
import com.burcu.mapper.RandevuMapper;
import com.burcu.repository.RandevuRepository;
import com.burcu.utility.enums.DoktorStatus;
import com.burcu.utility.enums.RandevuStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RandevuService {
    private final RandevuRepository randevuRepository;
    private final DoktorService doktorService;


    /**
     * Kullanıcıların üye olmadan randevu alabilmelerini sağlayan methodtur.
     * @param dto
     * @return
     */
    public Randevu save(RandevuSaveRequestDto dto) {
        //İstenilen id'de doktor var mı diye kontrol eder.
        Optional<Doktor> doktorOptional= doktorService.findById(dto.getDoktorId());

        //Doktor id'si, tarih ve saate göre daha önceden bir randevu oluşturulmuş mu kontrol eder.
        List<Randevu> randevuList=randevuRepository.findAllByDoktorIdAndTarihAndSaat(doktorOptional.get().getId(),dto.getTarih(),dto.getSaat());
        if(!randevuList.isEmpty()){
            throw new DoktorRandevuAppException(ErrorType.RANDEVU_IS_FULL);
        }

        Doktor doktor = doktorOptional.get();
        doktor.setDoktorStatus(DoktorStatus.DOLU); // Randevu alındığında doktorun durumunu dolu olarak günceller.
        doktorService.update(doktor);

        Randevu randevu= RandevuMapper.INSTANCE.fromRandevuSaveRequestDtoToRandevu(dto); //Yeni bir randevu nesnesi yaratır.
        randevu.setHastaAdi(dto.getHastaAdi());
        randevu.setDoktorId(doktor.getId());
        randevu.setStatus(RandevuStatus.AKTIF); //Randevu alındığında randevunun durumunu aktif olarak günceller.

        return randevuRepository.save(randevu);
    }



}
