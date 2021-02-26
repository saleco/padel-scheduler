package com.padel.scheduler.user.service;

import com.padel.scheduler.exceptions.NotFoundException;
import com.padel.scheduler.user.dto.UserDto;
import com.padel.scheduler.user.mapper.UserMapper;
import com.padel.scheduler.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto save(UserDto userDTO) {
        return userMapper.userToUserDto(userRepository.save(userMapper.userDtoToUser(userDTO)));

    }

    @Override
    public List<UserDto> list() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), true)
          .map(userMapper::userToUserDto)
          .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer userId) {
        return userRepository.findById(userId)
                .map(userMapper::userToUserDto)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }
}
