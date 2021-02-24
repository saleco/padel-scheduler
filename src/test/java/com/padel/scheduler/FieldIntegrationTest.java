package com.padel.scheduler;

import com.padel.scheduler.converters.FieldMapperImpl;
import com.padel.scheduler.converters.LocationMapperImpl;
import com.padel.scheduler.dtos.LocationDto;
import com.padel.scheduler.dtos.FieldDto;
import com.padel.scheduler.repositories.LocationRepository;
import com.padel.scheduler.repositories.FieldRepository;
import com.padel.scheduler.services.ClubService;
import com.padel.scheduler.services.FieldService;
import com.padel.scheduler.services.Impl.FieldServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class FieldIntegrationTest {

    @Autowired
    private FieldRepository fieldRepository;

    @Autowired
    private FieldService fieldService;

    @Autowired
    private FieldMapperImpl fieldMapper;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ClubService clubService;

    @Autowired
    private LocationMapperImpl locationMapper;

    @BeforeEach
    void setup() {
        fieldService = new FieldServiceImpl(fieldRepository, fieldMapper);
    }

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
                .build())
        ;
    }

    private LocationDto createClubDtoPP() {
        return clubService.save(LocationDto.builder()
                .name("Padel nas Piramides")
                .createTime(LocalDateTime.now())
                .build());
    }
}
