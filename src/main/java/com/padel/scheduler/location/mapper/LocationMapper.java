package com.padel.scheduler.location.mapper;

import com.padel.scheduler.base.mappers.BaseMapper;
import com.padel.scheduler.field.mapper.FieldMapper;
import com.padel.scheduler.location.dto.LocationDto;
import com.padel.scheduler.location.model.Location;
import org.mapstruct.Mapper;

@Mapper(uses = {FieldMapper.class})
public interface LocationMapper extends BaseMapper<LocationDto, Location> {

}
