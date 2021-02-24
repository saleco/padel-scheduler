package com.padel.scheduler.services;

import com.padel.scheduler.dtos.LocationDto;

import java.util.List;

public interface LocationService {

    LocationDto save(LocationDto locationDto);
    List<LocationDto> list();

    LocationDto findById(Integer id);
}
