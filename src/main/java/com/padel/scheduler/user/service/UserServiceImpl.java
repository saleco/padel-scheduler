package com.padel.scheduler.user.service;

import com.padel.scheduler.dto.PageableRequestDto;
import com.padel.scheduler.exceptions.NotFoundException;
import com.padel.scheduler.user.dto.UserDto;
import com.padel.scheduler.user.mapper.UserMapper;
import com.padel.scheduler.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

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
    public Page<UserDto> list(PageableRequestDto pageableRequestDto) {
        Pageable pageable = PageRequest.of(pageableRequestDto.getPage(), pageableRequestDto.getSize());

        return new PageImpl(
          userRepository.findAll(pageable).getContent().stream()
            .map(userMapper::userToUserDto)
            .collect(Collectors.toList())
        );

    }

    @Override
    public UserDto findById(Integer userId) {
        return userRepository.findById(userId)
                .map(userMapper::userToUserDto)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }
}
