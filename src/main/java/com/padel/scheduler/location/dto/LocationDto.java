package com.padel.scheduler.location.dto;

import com.padel.scheduler.field.dto.FieldDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LocationDto {

    private Integer id;
    private String name;
    private LocalDateTime createTime;
    private List<FieldDto> fieldDtos;

}
