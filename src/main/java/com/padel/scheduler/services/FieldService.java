package com.padel.scheduler.services;

import com.padel.scheduler.dtos.FieldDto;

import java.util.List;

public interface FieldService {

    FieldDto save(FieldDto fieldDto);
    List<FieldDto> list();
    FieldDto findById(Integer id);
}
