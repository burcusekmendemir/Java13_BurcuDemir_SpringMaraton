package com.burcu.controller;

import com.burcu.dto.request.DoktorSaveRequestDto;
import com.burcu.dto.response.DoktorStatusResponseDto;
import com.burcu.entity.Doktor;
import com.burcu.service.DoktorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.burcu.constants.RestApiUrls.*;

@RestController
@RequestMapping(DOKTOR)
@RequiredArgsConstructor
public class DoktorController {
    private final DoktorService doktorService;

    @PostMapping(SAVE)
    public ResponseEntity<Void> save(@RequestBody @Valid DoktorSaveRequestDto dto){
        doktorService.save(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<Doktor>> findAll(){
        return ResponseEntity.ok(doktorService.findAll());
    }

    @GetMapping(GET_ALL_DOKTOR_BY_STATUS)
    public ResponseEntity<List<DoktorStatusResponseDto>> findAllDoktorByStatus(){
        return ResponseEntity.ok(doktorService.findAllDoktorByStatus());
    }
}
