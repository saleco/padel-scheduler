package com.padel.scheduler.base.dto;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageableRequestDto {

    @Parameter(name = "$page", description = "Page number. Starting from 0")
    private int page;

    @Parameter(name = "$size", description = "Page size. By default 20")
    private int size = 20;
}
