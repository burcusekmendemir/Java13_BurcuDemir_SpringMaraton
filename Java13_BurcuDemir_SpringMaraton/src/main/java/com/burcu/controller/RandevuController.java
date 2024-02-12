package com.burcu.controller;

import com.burcu.dto.request.RandevuSaveRequestDto;
import com.burcu.service.RandevuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.burcu.constants.RestApiUrls.*;

@RestController
@RequestMapping(RANDEVU)
@RequiredArgsConstructor
public class RandevuController {
    private final RandevuService randevuService;

    @PostMapping(SAVE)
    public ResponseEntity<Void> save(@RequestBody @Valid RandevuSaveRequestDto dto){
        randevuService.save(dto);
        return ResponseEntity.ok().build();
    }
}
