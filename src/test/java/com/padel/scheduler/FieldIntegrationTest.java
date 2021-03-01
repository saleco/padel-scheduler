package com.padel.scheduler;

import com.padel.scheduler.base.services.CrudService;
import com.padel.scheduler.factories.FieldFactory;
import com.padel.scheduler.factories.LocationFactory;
import com.padel.scheduler.field.dto.FieldDto;
import com.padel.scheduler.field.service.FieldServiceImpl;
import com.padel.scheduler.location.dto.LocationDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FieldIntegrationTest {

    @Autowired
    private FieldServiceImpl fieldService;

    @Autowired
    private CrudService<LocationDto> locationService;

    @DisplayName("Creates a Location and check Location created.")
    @Test
    void createLocation_ThenCheckLocationCreated() {
        LocationDto locationDto = createLocationPadelNasPiramides();
        LocationDto locationDtoCheck = locationService.findById(locationDto.getId());

        assertAll(
          () -> assertNotNull(locationDtoCheck),
          () -> assertEquals("Padel nas Piramides", locationDtoCheck.getName()),
          () -> assertEquals("38.705448", locationDtoCheck.getLatitude()),
          () -> assertEquals("-8.976149", locationDtoCheck.getLongitude()),
          () -> assertTrue(locationDtoCheck.getCreateTime().isBefore(LocalDateTime.now()))
        );
    }

    @DisplayName("Creates a Field in a Location and check Field created with the Location.")
    @Test
    void createField_ThenCheckFieldCreated() {
        FieldDto fieldDto = createFieldQuadra1InPadelNasPiramidades();
        FieldDto fieldDtoCheck = fieldService.findById(fieldDto.getId());

        List<FieldDto> fieldsByLocation = fieldService.findFieldsByLocation(fieldDtoCheck.getLocation());

        assertAll(
          () -> assertNotNull(fieldDtoCheck),
          () -> assertNotNull(fieldDtoCheck.getLocation())
        );
    }

    private FieldDto createFieldQuadra1InPadelNasPiramidades() {
        return createField("Quadra 1", false, createLocationPadelNasPiramides());
    }

    private FieldDto createField(String name, boolean covered, LocationDto locationDto) {
        return fieldService.save(
          FieldFactory.createFieldDto(name, covered, locationDto)
        );
    }

    private LocationDto createLocationPadelNasPiramides() {
        return locationService.save(LocationFactory.createLocationDto("Padel nas Piramides", "38.705448", "-8.976149"));
    }
}
