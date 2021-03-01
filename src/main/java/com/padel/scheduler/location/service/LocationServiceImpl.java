package com.padel.scheduler.location.service;

import com.padel.scheduler.base.dto.PageableRequestDto;
import com.padel.scheduler.base.services.CrudServiceImpl;
import com.padel.scheduler.location.dto.LocationDto;
import com.padel.scheduler.location.mapper.LocationMapper;
import com.padel.scheduler.location.model.Location;
import com.padel.scheduler.location.repository.LocationRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl extends CrudServiceImpl<LocationDto, Location> {

    public LocationServiceImpl(LocationRepository repository, LocationMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public LocationDto save(LocationDto locationDto) {
        return super.save(locationDto);
    }

    @Override
    public Page<LocationDto> list(PageableRequestDto pageableRequestDto) {
        return super.list(pageableRequestDto);
    }

    @Override
    public LocationDto findById(Integer id) {
        return super.findById(id);
    }
}
