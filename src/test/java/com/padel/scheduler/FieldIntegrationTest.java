package com.padel.scheduler;

import com.padel.scheduler.field.dto.FieldDto;
import com.padel.scheduler.field.service.FieldService;
import com.padel.scheduler.location.dto.LocationDto;
import com.padel.scheduler.location.service.LocationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class FieldIntegrationTest {


    @Autowired
    private FieldService fieldService;

    @Autowired
    private LocationService locationService;


    @Test
    void createField_ThenCheckFieldCreated() {
        createField();
        List<FieldDto> fieldDtos = fieldService.list();
        assertNotNull(fieldDtos);
        assertFalse(fieldDtos.isEmpty());
    }

    private FieldDto createField() {
       return fieldService.save(FieldDto.builder()
                .number(1)
                .createTime(LocalDateTime.now())
                .isCovert(false)
                .locationDto(createClubDtoPP())
                .build());
    }

    private LocationDto createClubDtoPP() {
        return locationService.save(LocationDto.builder()
                .name("Padel nas Piramides")
                .createTime(LocalDateTime.now())
                .fieldDtos(new LinkedList<>())
                .build());
    }
}
