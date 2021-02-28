package com.padel.scheduler.factories;

import com.padel.scheduler.location.dto.LocationDto;

import java.time.LocalDateTime;

public class LocationFactory {

    public static LocationDto createLocationDto(String name, String latitude, String longitude) {
        return LocationDto.builder()
          .name(name)
          .createTime(LocalDateTime.now())
          .latitude(latitude)
          .longitude(longitude)
          .build();
    }
}
