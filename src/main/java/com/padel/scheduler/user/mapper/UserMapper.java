package com.padel.scheduler.user.mapper;

import com.padel.scheduler.base.mappers.BaseMapper;
import com.padel.scheduler.user.dto.UserDto;
import com.padel.scheduler.user.model.User;
import com.padel.scheduler.usertype.mapper.UserTypeMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {UserTypeMapper.class})
public interface UserMapper extends BaseMapper<UserDto, User> {

}
