package com.padel.scheduler.location.service;

import com.padel.scheduler.location.dto.LocationDto;

import java.util.List;

public interface LocationService {

    LocationDto save(LocationDto club);
    List<LocationDto> list();
    LocationDto findById(Integer id);
}
