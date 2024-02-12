package com.burcu.mapper;

import com.burcu.dto.request.DoktorSaveRequestDto;
import com.burcu.entity.Doktor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DoktorMapper {
    DoktorMapper INSTANCE= Mappers.getMapper(DoktorMapper.class);

    Doktor fromDoktorSaveRequestDtoToDoktor(final DoktorSaveRequestDto dto);

}
