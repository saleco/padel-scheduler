package com.padel.scheduler.services;

import com.padel.scheduler.converters.UserConverter;
import com.padel.scheduler.dtos.UserDto;
import com.padel.scheduler.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public UserDto save(UserDto userDTO) {
        return userConverter.userToUserDto(userRepository.save(userConverter.userDtoToUser(userDTO)));
    }

    @Override
    public List<UserDto> list() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), true)
          .map(userConverter::userToUserDto)
          .collect(Collectors.toList());
    }
}
