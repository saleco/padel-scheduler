package com.padel.scheduler.dtos;

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
    private boolean isCovert;
    private int number;
    private LocalDateTime createTime;
    private LocationDto locationDto;

}
