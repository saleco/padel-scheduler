package com.padel.scheduler.location.mapper;

import com.padel.scheduler.field.mapper.FieldMapper;
import com.padel.scheduler.location.dto.LocationDto;
import com.padel.scheduler.location.model.Location;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {FieldMapper.class})
public interface LocationMapper {

    @Mapping(source = "fieldDtos", target = "fields")
    Location locationDtoToLocation(LocationDto locationDto);

    @Mapping(source = "fields", target = "fieldDtos")
    LocationDto locationToLocationDto(Location location);

}
