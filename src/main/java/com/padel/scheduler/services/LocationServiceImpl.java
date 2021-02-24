package com.padel.scheduler.services;

import com.padel.scheduler.converters.LocationMapper;
import com.padel.scheduler.dtos.LocationDto;
import com.padel.scheduler.exceptions.NotFoundException;
import com.padel.scheduler.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    @Override
    public LocationDto save(LocationDto locationDto) {
        return locationMapper.locationToLocationDto(locationRepository.save(locationMapper.locationDtoToLocation(locationDto)));
    }

    @Override
    public List<LocationDto> list() {
        return StreamSupport.stream(locationRepository.findAll().spliterator(),true)
                .map(locationMapper::locationToLocationDto)
                .collect(Collectors.toList());
    }

    @Override
    public LocationDto findById(Integer id) {
        return locationRepository.findById(id)
                .map(locationMapper::locationToLocationDto)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }
}
