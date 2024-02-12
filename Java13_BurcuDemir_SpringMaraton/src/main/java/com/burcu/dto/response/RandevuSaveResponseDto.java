package com.burcu.dto.response;


import com.burcu.utility.enums.RandevuStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RandevuSaveResponseDto {
    private String doktorAdi;
    private String hastaAdi;
    private String tarih;
    private String saat;
    private RandevuStatus status;
}
