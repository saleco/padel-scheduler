package com.padel.scheduler;

import com.padel.scheduler.converters.ClubMapperImpl;
import com.padel.scheduler.converters.FieldMapperImpl;
import com.padel.scheduler.dtos.ClubDto;
import com.padel.scheduler.dtos.FieldDto;
import com.padel.scheduler.repositories.ClubRepository;
import com.padel.scheduler.repositories.FieldRepository;
import com.padel.scheduler.services.ClubService;
import com.padel.scheduler.services.FieldService;
import com.padel.scheduler.services.Impl.FieldServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private ClubRepository clubRepository;

    @Autowired
    private ClubService clubService;

    @Autowired
    private ClubMapperImpl clubMapper;

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
                .clubDto(createClubDtoPP())
                .build())
        ;
    }

    private ClubDto createClubDtoPP() {
        return clubService.save(ClubDto.builder()
                .name("Padel nas Piramides")
                .createTime(LocalDateTime.now())
                .fieldDtos(new ArrayList<>())
                .build());
    }
}
