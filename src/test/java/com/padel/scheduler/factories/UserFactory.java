package com.padel.scheduler.factories;

import com.padel.scheduler.user.dto.UserDto;
import com.padel.scheduler.usertype.dto.UserTypeDto;

import java.time.LocalDateTime;

public class UserFactory {

    public static UserDto createUserDto(String username, String email, String password, UserTypeDto userTypeDto) {
        return UserDto.builder()
          .username(username)
          .email(email)
          .createTime(LocalDateTime.now())
          .password(password)
          .userTypeDto(userTypeDto)
          .build();
    }
}
