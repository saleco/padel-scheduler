package com.padel.scheduler.factories;

import com.padel.scheduler.usertype.dto.UserTypeDto;

public class UserTypeFactory {

    public static UserTypeDto createUserTypeDto(String name) {
        return UserTypeDto.builder()
          .name(name)
          .build();
    }
}
