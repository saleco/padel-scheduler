package com.padel.scheduler.services;

import com.padel.scheduler.converters.UserConverterImpl;
import com.padel.scheduler.dtos.UserDto;
import com.padel.scheduler.repositories.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected UserConverterImpl userConverter;

    @BeforeEach
    void setup() {
        userService = new UserServiceImpl(userRepository, userConverter);

    }

    @Test
    void createUser_ThenCheckUserCreated() {
        createUserJoao();
        createUserSallo();
        List<UserDto> userDtos = userService.list();
        assertNotNull(userDtos);
        assertFalse(userDtos.isEmpty());
        assertTrue(userDtos.size() == 2);
        userDtos.forEach(userDto -> {
            assertNotNull(userDto.getUserId());
            assertTrue(userDto.getUserId() > 0);
            assertNotNull(userDto.getUsername());
            assertTrue(StringUtils.isNotEmpty(userDto.getUsername()));
            assertNotNull(userDto.getEmail());
            assertTrue(StringUtils.isNotEmpty(userDto.getEmail()));
        });
    }

    private void createUserJoao() {
        userService.save(UserDto.builder()
          .username("joao.miguel")
          .email("joao.miguel@gmail.com")
          .createTime(LocalDateTime.now())
          .password("mypass")
          .build());
    }

    private void createUserSallo() {
        userService.save(UserDto.builder()
          .username("sallo.szrajbman")
          .email("sallo.szrajbmanl@hotmail.com")
          .createTime(LocalDateTime.now())
          .password("sallosallo")
          .build());
    }

}