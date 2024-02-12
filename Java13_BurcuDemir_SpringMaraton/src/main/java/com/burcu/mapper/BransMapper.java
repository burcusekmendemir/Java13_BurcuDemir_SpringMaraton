package com.burcu.mapper;

import com.burcu.dto.request.BransSaveRequestDto;
import com.burcu.dto.request.DoktorSaveRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BransMapper {
    BransMapper INSTANCE= Mappers.getMapper(BransMapper.class);
    BransSaveRequestDto fromDoktorDtoToBransDto(final DoktorSaveRequestDto dto);
}
