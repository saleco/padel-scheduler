package com.padel.scheduler.user.service;

import com.padel.scheduler.user.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto save(UserDto userDTO);
    List<UserDto> list();

    UserDto findById(Integer userId);
}
