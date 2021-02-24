package com.padel.scheduler.converters;

import com.padel.scheduler.dtos.FieldDto;
import com.padel.scheduler.model.Field;
import org.mapstruct.Mapper;

@Mapper(uses = {LocationMapper.class})
public interface FieldMapper {

    FieldDto fieldToFieldDto(Field field);

    Field fieldDtoToField(FieldDto fieldDto);

}
