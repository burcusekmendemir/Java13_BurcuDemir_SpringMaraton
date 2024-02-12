package com.burcu.mapper;

import com.burcu.dto.request.RandevuSaveRequestDto;
import com.burcu.entity.Randevu;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RandevuMapper {
    RandevuMapper INSTANCE= Mappers.getMapper(RandevuMapper.class);
    Randevu fromRandevuSaveRequestDtoToRandevu(final RandevuSaveRequestDto dto);
}
