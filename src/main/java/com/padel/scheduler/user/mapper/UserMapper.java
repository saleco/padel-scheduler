package com.padel.scheduler.user.mapper;

import com.padel.scheduler.user.dto.UserDto;
import com.padel.scheduler.user.model.User;
import com.padel.scheduler.usertype.mapper.UserTypeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {UserTypeMapper.class})
public interface UserMapper {

    @Mapping(source = "user.userType", target = "userTypeDto")
    UserDto userToUserDto(User user);
    @Mapping(source = "userDto.userTypeDto", target = "userType")
    User userDtoToUser(UserDto userDto);
}
