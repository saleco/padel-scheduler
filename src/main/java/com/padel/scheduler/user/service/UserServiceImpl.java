package com.padel.scheduler.user.service;

import com.padel.scheduler.base.dto.PageableRequestDto;
import com.padel.scheduler.base.services.CrudServiceImpl;
import com.padel.scheduler.user.dto.UserDto;
import com.padel.scheduler.user.mapper.UserMapper;
import com.padel.scheduler.user.model.User;
import com.padel.scheduler.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends CrudServiceImpl<UserDto, User> {

    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
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
