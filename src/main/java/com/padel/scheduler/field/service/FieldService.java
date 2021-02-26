package com.padel.scheduler.field.service;

import com.padel.scheduler.field.dto.FieldDto;

import java.util.List;

public interface FieldService {

    FieldDto save(FieldDto fieldDto);
    List<FieldDto> list();
    FieldDto findById(Integer id);
}
