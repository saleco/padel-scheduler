package com.padel.scheduler.field.service;

import com.padel.scheduler.base.dto.PageableRequestDto;
import com.padel.scheduler.base.mappers.BaseMapper;
import com.padel.scheduler.base.services.CrudServiceImpl;
import com.padel.scheduler.field.dto.FieldDto;
import com.padel.scheduler.field.model.Field;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class FieldServiceImpl extends CrudServiceImpl<FieldDto, Field> {

    public FieldServiceImpl(JpaRepository<Field, Integer> repository, BaseMapper<FieldDto, Field> mapper) {
        super(repository, mapper);
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
}
