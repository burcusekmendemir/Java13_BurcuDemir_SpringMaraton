package com.burcu.dto.response;

import com.burcu.utility.enums.DoktorStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class DoktorStatusResponseDto {

    private Long id;
    private String doktorAdi;
    private DoktorStatus doktorStatus;
    private List<RandevuStatusResponseDto> randevuList;
}
