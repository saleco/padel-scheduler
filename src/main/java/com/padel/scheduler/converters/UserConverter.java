package com.padel.scheduler.converters;

import com.padel.scheduler.dtos.UserDto;
import com.padel.scheduler.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserConverter  {

    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
}
