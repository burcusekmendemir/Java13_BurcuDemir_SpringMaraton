package com.burcu.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class RandevuSaveRequestDto {
    private Long doktorId;
    private String hastaAdi;
    private String tarih;
    private String saat;
}
