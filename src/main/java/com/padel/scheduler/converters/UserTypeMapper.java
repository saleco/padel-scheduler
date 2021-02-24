package com.padel.scheduler.converters;

import com.padel.scheduler.dtos.UserDto;
import com.padel.scheduler.dtos.UserTypeDto;
import com.padel.scheduler.model.User;
import com.padel.scheduler.model.UserType;
import org.mapstruct.Mapper;

@Mapper
public interface UserTypeMapper {

    UserTypeDto userTypeToUserTypeDto(UserType userType);
    UserType userTypeDtoToUserType(UserTypeDto userTypeDto);

}
