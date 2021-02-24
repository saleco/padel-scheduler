package com.padel.scheduler.services;

import com.padel.scheduler.converters.UserTypeMapper;
import com.padel.scheduler.dtos.UserTypeDto;
import com.padel.scheduler.repositories.UserTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserTypeServiceImpl implements UserTypeService {

    private final UserTypeRepository userTypeRepository;
    private final UserTypeMapper userTypeMapper;

    @Override
    public UserTypeDto save(UserTypeDto userTypeDto) {
        return userTypeMapper.userTypeToUserTypeDto(userTypeRepository.save(userTypeMapper.userTypeDtoToUserType(userTypeDto)));
    }
}
