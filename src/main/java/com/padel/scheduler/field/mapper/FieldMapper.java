package com.padel.scheduler.field.mapper;

import com.padel.scheduler.base.mappers.BaseMapper;
import com.padel.scheduler.field.dto.FieldDto;
import com.padel.scheduler.field.model.Field;
import com.padel.scheduler.location.mapper.LocationMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {LocationMapper.class})
public interface FieldMapper extends BaseMapper<FieldDto, Field> {
}
