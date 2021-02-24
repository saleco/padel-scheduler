package com.padel.scheduler.converters;

import com.padel.scheduler.dtos.LocationDto;
import com.padel.scheduler.model.Location;
import org.mapstruct.Mapper;

@Mapper
public interface LocationMapper {

    LocationDto locationToLocationDto(Location location);
    Location locationDtoToLocation(LocationDto locationDto);

}
