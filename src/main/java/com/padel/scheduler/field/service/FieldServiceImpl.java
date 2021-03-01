package com.padel.scheduler.field.service;

import com.padel.scheduler.base.dto.PageableRequestDto;
import com.padel.scheduler.base.services.CrudServiceImpl;
import com.padel.scheduler.field.dto.FieldDto;
import com.padel.scheduler.field.mapper.FieldMapper;
import com.padel.scheduler.field.model.Field;
import com.padel.scheduler.field.repository.FieldRepository;
import com.padel.scheduler.location.dto.LocationDto;
import com.padel.scheduler.location.mapper.LocationMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FieldServiceImpl extends CrudServiceImpl<FieldDto, Field> implements FieldService {

    private final LocationMapper locationMapper;
    private final FieldRepository fieldRepository;

    public FieldServiceImpl(FieldRepository repository, FieldMapper mapper, LocationMapper locationMapper) {
        super(repository, mapper);
        this.locationMapper = locationMapper;
        this.fieldRepository = repository;
    }

    @Override
    public FieldDto save(FieldDto fieldDto) {
        return super.save(fieldDto);
    }

    @Override
    public Page<FieldDto> list(PageableRequestDto pageableRequestDto) {
        return super.list(pageableRequestDto);
    }

    @Override
    public FieldDto findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public List<FieldDto> findFieldsByLocation(LocationDto location) {
        return fieldRepository.findAllByLocation(locationMapper.dtoToModel(location)).stream()
          .map(mapper::modelToDto)
          .collect(Collectors.toList());
    }
}
