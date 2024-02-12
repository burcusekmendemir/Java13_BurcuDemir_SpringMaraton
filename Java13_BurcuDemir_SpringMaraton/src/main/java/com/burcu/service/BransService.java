package com.burcu.service;

import com.burcu.dto.request.BransSaveRequestDto;
import com.burcu.entity.Brans;
import com.burcu.repository.BransRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BransService {
    private final BransRepository bransRepository;

    /**
     * Brans'ın kaydedilmesini sağlar.
     * @param dto
     * @return
     */
    public Brans save(BransSaveRequestDto dto){
        Optional<Brans> brans=bransRepository.findByBransName(dto.getBransName());
        return brans.orElseGet(() -> bransRepository.save(Brans.builder()
                .bransName(dto.getBransName())
                .build()));
    }
}
