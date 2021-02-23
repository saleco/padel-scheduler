package com.padel.scheduler.services;

import com.padel.scheduler.dtos.UserDto;

import java.util.List;

public interface UserService {

    UserDto save(UserDto userDTO);
    List<UserDto> list();
}
