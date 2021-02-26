package com.padel.scheduler.field.service;

import com.padel.scheduler.exceptions.NotFoundException;
import com.padel.scheduler.field.dto.FieldDto;
import com.padel.scheduler.field.mapper.FieldMapper;
import com.padel.scheduler.field.repository.FieldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class FieldServiceImpl implements FieldService {

    private final FieldRepository fieldRepository;
    private final FieldMapper fieldMapper;

    @Override
    public FieldDto save(FieldDto fieldDto) {
        return fieldMapper.fieldToFieldDto(fieldRepository.save(fieldMapper.fieldDtoToField(fieldDto)));
    }

    @Override
    public List<FieldDto> list() {
        return StreamSupport.stream(fieldRepository.findAll().spliterator(), true)
                .map(fieldMapper::fieldToFieldDto)
                .collect(Collectors.toList());
    }

    @Override
    public FieldDto findById(Integer id) {
        return fieldRepository.findById(id)
                .map(fieldMapper::fieldToFieldDto)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }
}
