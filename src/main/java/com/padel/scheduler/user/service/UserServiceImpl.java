package com.padel.scheduler.user.service;

import com.padel.scheduler.base.dto.PageableRequestDto;
import com.padel.scheduler.base.mappers.BaseMapper;
import com.padel.scheduler.base.services.CrudServiceImpl;
import com.padel.scheduler.user.dto.UserDto;
import com.padel.scheduler.user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends CrudServiceImpl<UserDto, User> {

    public UserServiceImpl(JpaRepository<User, Integer> repository, BaseMapper<UserDto, User> mapper) {
        super(repository, mapper);
    }

    @Override
    public UserDto save(UserDto userDto) {
        return super.save(userDto);

    }

    @Override
    public Page<UserDto> list(PageableRequestDto pageableRequestDto) {
        return super.list(pageableRequestDto);
    }

    @Override
    public UserDto findById(Integer userId) {
        return super.findById(userId);
    }
}
