package com.padel.scheduler.converters;

import com.padel.scheduler.dtos.UserDto;
import com.padel.scheduler.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {UserTypeMapper.class})
public interface UserMapper {

    @Mapping(source = "user.userType", target = "userTypeDto")
    UserDto userToUserDto(User user);
    @Mapping(source = "userDto.userTypeDto", target = "userType")
    User userDtoToUser(UserDto userDto);
}
