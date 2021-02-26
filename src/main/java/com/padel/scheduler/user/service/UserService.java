package com.padel.scheduler.user.service;

import com.padel.scheduler.dto.PageableRequestDto;
import com.padel.scheduler.user.dto.UserDto;
import org.springframework.data.domain.Page;

public interface UserService {

    UserDto save(UserDto userDTO);
    Page<UserDto> list(PageableRequestDto pageableRequestDto);

    UserDto findById(Integer userId);
}
