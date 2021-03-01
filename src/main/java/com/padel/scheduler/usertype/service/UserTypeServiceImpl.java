package com.padel.scheduler.usertype.service;

import com.padel.scheduler.base.services.CrudServiceImpl;
import com.padel.scheduler.usertype.dto.UserTypeDto;
import com.padel.scheduler.usertype.mapper.UserTypeMapper;
import com.padel.scheduler.usertype.model.UserType;
import com.padel.scheduler.usertype.repository.UserTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class UserTypeServiceImpl extends CrudServiceImpl<UserTypeDto, UserType> {

    public UserTypeServiceImpl(UserTypeRepository repository, UserTypeMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public UserTypeDto save(UserTypeDto userTypeDto) {
        return super.save(userTypeDto);
    }
}
