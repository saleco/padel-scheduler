package com.padel.scheduler;

import com.padel.scheduler.base.dto.PageableRequestDto;
import com.padel.scheduler.base.services.CrudService;
import com.padel.scheduler.field.dto.FieldDto;
import com.padel.scheduler.location.dto.LocationDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class FieldIntegrationTest {

    @Autowired
    private CrudService<FieldDto> fieldService;

    @Autowired
    private CrudService<LocationDto> locationService;

    @Test
    void createField_ThenCheckFieldCreated() {
        createField();
        Page<FieldDto> fieldDtos = fieldService.list(new PageableRequestDto(0, 20));
        assertNotNull(fieldDtos);
        assertFalse(fieldDtos.isEmpty());
    }

    private FieldDto createField() {
       return fieldService.save(FieldDto.builder()
                .name("Quadra 1")
                .createTime(LocalDateTime.now())
                .covered(false)
                .locationDto(createClubDtoPP())
                .build());
    }

    private LocationDto createClubDtoPP() {
        return locationService.save(LocationDto.builder()
                .name("Padel nas Piramides")
                .createTime(LocalDateTime.now())
                .fields(new LinkedList<>())
                .build());
    }
}
