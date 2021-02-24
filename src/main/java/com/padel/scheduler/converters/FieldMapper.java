package com.padel.scheduler.converters;

import com.padel.scheduler.dtos.FieldDto;
import com.padel.scheduler.model.Field;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {ClubMapper.class})
public interface FieldMapper {

    @Mapping(source = "club", target = "clubDto")
    FieldDto fieldToFieldDto(Field field);

    @Mapping(source = "clubDto", target = "club")
    Field fieldDtoToField(FieldDto fieldDto);

}
