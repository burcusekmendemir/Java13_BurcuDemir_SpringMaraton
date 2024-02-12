package com.burcu.dto.request;

import com.burcu.utility.enums.Unvan;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class DoktorSaveRequestDto {


    private Long id;
    private String doktorAdi;
    private String bransName;
    @Enumerated(EnumType.STRING)
    private Unvan unvan;


}
