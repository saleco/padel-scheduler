package com.padel.scheduler.services.Impl;

import com.padel.scheduler.converters.FieldMapper;
import com.padel.scheduler.dtos.FieldDto;
import com.padel.scheduler.exceptions.NotFoundException;
import com.padel.scheduler.repositories.FieldRepository;
import com.padel.scheduler.services.FieldService;
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
