package com.padel.scheduler.services;

import com.padel.scheduler.dtos.LocationDto;

import java.util.List;

public interface ClubService {

    LocationDto save(LocationDto club);
    List<LocationDto> list();
    LocationDto findById(Integer id);
}
