package com.padel.scheduler;

import com.padel.scheduler.converters.UserMapperImpl;
import com.padel.scheduler.dtos.UserDto;
import com.padel.scheduler.dtos.UserTypeDto;
import com.padel.scheduler.repositories.UserRepository;
import com.padel.scheduler.services.UserService;
import com.padel.scheduler.services.UserServiceImpl;
import com.padel.scheduler.services.UserTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected UserMapperImpl userMapper;

    @Autowired
    private UserTypeService userTypeService;

    @BeforeEach
    void setup() {
        userService = new UserServiceImpl(userRepository, userMapper);

    }

    @Test
    void createUser_ThenCheckUserCreated() {
        createUserJoao();
        createUserSallo();
        List<UserDto> userDtos = userService.list();
        assertNotNull(userDtos);
        assertFalse(userDtos.isEmpty());
    }

    @Test
    void createUser_ThenCheckFields() {
        UserDto userDto = createUserSallo();
        UserDto userDtoCheck = userService.findById(userDto.getUserId());

        assertAll("Check User fields",
                () -> assertNotNull(userDtoCheck),
                () -> assertTrue(userDtoCheck.getUserId() > 0),
                () -> assertFalse(userDtoCheck.getEmail().isEmpty()),
                () -> assertFalse(userDtoCheck.getUsername().isEmpty()),
                () -> assertFalse(userDtoCheck.getPassword().isEmpty()),
                () -> assertNotNull(userDtoCheck.getCreateTime()),
                () -> assertTrue(userDtoCheck.getCreateTime().isBefore(LocalDateTime.now())),
                () -> assertEquals("sallo.szrajbman", userDtoCheck.getUsername()),
                () -> assertEquals("sallo.szrajbmanl@hotmail.com", userDtoCheck.getEmail()),
                () -> assertEquals("sallosallo", userDtoCheck.getPassword())

        );
    }

    @Test
    void createUserWhenUserTypeEqualsProfessor_ThenCheckFields() {
        UserDto userDto = createUserSallo();
        UserDto userDtoCheck = userService.findById(userDto.getUserId());

        assertAll("Check User with User Type Professor",
                () -> assertNotNull(userDtoCheck.getUserTypeDto()),
                () -> assertTrue(userDtoCheck.getUserTypeDto().getId() > 0),
                () -> assertEquals("Professor", userDtoCheck.getUserTypeDto().getName())

        );
    }

    @Test
    void createUserWhenUserTypeEqualsAluno_ThenCheckFields() {
        UserDto userDto = createUserJoao();
        UserDto userDtoCheck = userService.findById(userDto.getUserId());

        assertAll("Check User with User Type Aluno",
                () -> assertNotNull(userDtoCheck.getUserTypeDto()),
                () -> assertTrue(userDtoCheck.getUserTypeDto().getId() > 0),
                () -> assertEquals("Aluno", userDtoCheck.getUserTypeDto().getName())

        );
    }

    private UserDto createUserJoao() {
        return userService.save(UserDto.builder()
                  .username("joao.miguel")
                  .email("joao.miguel@gmail.com")
                  .createTime(LocalDateTime.now())
                  .password("mypass")
                  .userTypeDto(creteUserTypeDtoAluno())
                  .build());
    }

    private UserDto createUserSallo() {
        return userService.save(UserDto.builder()
                .username("sallo.szrajbman")
                .email("sallo.szrajbmanl@hotmail.com")
                .createTime(LocalDateTime.now())
                .password("sallosallo")
                .userTypeDto(creteUserTypeDtoProfessor())
                .build());
    }

    private UserTypeDto creteUserTypeDtoProfessor(){
        return userTypeService.save(UserTypeDto.builder()
                .name("Professor")
                .build());
    }

    private UserTypeDto creteUserTypeDtoAluno(){
        return userTypeService.save(UserTypeDto.builder()
                .name("Aluno")
                .build());
    }

}