package com.padel.scheduler.usertype.service;

import com.padel.scheduler.usertype.dto.UserTypeDto;
import com.padel.scheduler.usertype.mapper.UserTypeMapper;
import com.padel.scheduler.usertype.repository.UserTypeRepository;
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
