package com.padel.scheduler;

import com.padel.scheduler.converters.LocationMapperImpl;
import com.padel.scheduler.dtos.LocationDto;
import com.padel.scheduler.model.Location;
import com.padel.scheduler.repositories.LocationRepository;
import com.padel.scheduler.services.LocationService;
import com.padel.scheduler.services.LocationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LocationIntegrationTest {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private LocationMapperImpl locationMapper;

    @Autowired
    private LocationService locationService;

    @BeforeEach
    void setup() {
        locationService = new LocationServiceImpl(locationRepository,locationMapper);
    }

    @Test
    void createLocation_thenCheckLocationCreated(){
        createLocationPP();
        List<LocationDto> locationDtos = locationService.list();
        assertNotNull(locationDtos);
        assertFalse(locationDtos.isEmpty());
    }

    @Test
    void createLocation_thenCheckFields(){
        LocationDto locationDto = createLocationPP();
        LocationDto locationDtoCheck = locationService.findById(locationDto.getId());


    }

    private LocationDto createLocationPP(){
        return locationService.save(LocationDto.builder()
                .name("Padel nas Piramides")
                .latitude("12345")
                .longitude("12345")
                .build());
    }

}