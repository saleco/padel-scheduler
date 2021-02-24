package com.padel.scheduler.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {

    private Integer id;
    private String latitude;
    private String longitude;
    private String name;
    private LocalDateTime createTime;


}
