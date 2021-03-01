package com.padel.scheduler.field.service;

import com.padel.scheduler.field.dto.FieldDto;
import com.padel.scheduler.location.dto.LocationDto;

import java.util.List;

public interface FieldService {
    List<FieldDto> findFieldsByLocation(LocationDto location);
}
