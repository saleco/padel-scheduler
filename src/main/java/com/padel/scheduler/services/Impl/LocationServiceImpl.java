package com.padel.scheduler.services.Impl;

import com.padel.scheduler.converters.LocationMapper;
import com.padel.scheduler.dtos.LocationDto;
import com.padel.scheduler.exceptions.NotFoundException;
import com.padel.scheduler.repositories.LocationRepository;
import com.padel.scheduler.services.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements ClubService {

    private final LocationRepository locationRepository;
    private final LocationMapper clubMapper;

    @Override
    public LocationDto save(LocationDto locationDto) {
        return clubMapper.clubToClubDto(locationRepository.save(clubMapper.clubDtoToClub(locationDto)));
    }

    @Override
    public List<LocationDto> list() {
        return StreamSupport.stream(locationRepository.findAll().spliterator(), true)
                .map(clubMapper::clubToClubDto)
                .collect(Collectors.toList());
    }

    @Override
    public LocationDto findById(Integer id) {
        return locationRepository.findById(id)
                .map(clubMapper::clubToClubDto)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }
}
