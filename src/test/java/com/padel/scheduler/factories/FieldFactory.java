package com.padel.scheduler.factories;

import com.padel.scheduler.field.dto.FieldDto;
import com.padel.scheduler.location.dto.LocationDto;

import java.time.LocalDateTime;

public class FieldFactory {

    public static FieldDto createFieldDto(String name, boolean covered, LocationDto locationDto) {
        return FieldDto.builder()
          .name(name)
          .createTime(LocalDateTime.now())
          .covered(covered)
          .location(locationDto)
          .build();
    }
}
