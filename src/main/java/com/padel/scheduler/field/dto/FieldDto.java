package com.padel.scheduler.field.dto;

import com.padel.scheduler.location.dto.LocationDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FieldDto {

    private Integer id;
    private String name;
    private boolean covered;
    private LocalDateTime createTime;
    private LocationDto locationDto;

}
