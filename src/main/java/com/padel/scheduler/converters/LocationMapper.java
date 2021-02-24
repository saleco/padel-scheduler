package com.padel.scheduler.converters;

import com.padel.scheduler.dtos.LocationDto;
import com.padel.scheduler.model.Location;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {FieldMapper.class})
public interface LocationMapper {

    @Mapping(source = "fieldDtos", target = "fields")
    Location clubDtoToClub(LocationDto locationDto);

    @Mapping(source = "fields", target = "fieldDtos")
    LocationDto clubToClubDto(Location location);

}
