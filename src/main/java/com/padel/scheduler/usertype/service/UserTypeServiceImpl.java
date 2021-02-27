package com.padel.scheduler.usertype.service;

import com.padel.scheduler.base.mappers.BaseMapper;
import com.padel.scheduler.base.services.CrudServiceImpl;
import com.padel.scheduler.usertype.dto.UserTypeDto;
import com.padel.scheduler.usertype.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserTypeServiceImpl extends CrudServiceImpl<UserTypeDto, UserType> {

    public UserTypeServiceImpl(JpaRepository<UserType, Integer> repository, BaseMapper<UserTypeDto, UserType> mapper) {
        super(repository, mapper);
    }

    @Override
    public UserTypeDto save(UserTypeDto userTypeDto) {
        return super.save(userTypeDto);
    }
}
