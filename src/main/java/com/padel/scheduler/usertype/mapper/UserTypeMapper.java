package com.padel.scheduler.usertype.mapper;

import com.padel.scheduler.base.mappers.BaseMapper;
import com.padel.scheduler.usertype.dto.UserTypeDto;
import com.padel.scheduler.usertype.model.UserType;
import org.mapstruct.Mapper;

@Mapper
public interface UserTypeMapper extends BaseMapper<UserTypeDto, UserType> {

}
