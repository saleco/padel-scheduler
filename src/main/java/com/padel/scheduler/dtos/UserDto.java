package com.padel.scheduler.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Integer userId;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createTime;
    private UserTypeDto userTypeDto;
}
