package com.padel.scheduler;

import com.padel.scheduler.base.dto.PageableRequestDto;
import com.padel.scheduler.base.services.CrudService;
import com.padel.scheduler.factories.UserFactory;
import com.padel.scheduler.factories.UserTypeFactory;
import com.padel.scheduler.user.dto.UserDto;
import com.padel.scheduler.usertype.dto.UserTypeDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserIntegrationTest {

    @Autowired
    private CrudService<UserDto> userService;

    @Autowired
    private CrudService<UserTypeDto> userTypeService;

    @DisplayName("Creates a user and check user list not empty.")
    @Test
    void createUser_ThenCheckUserCreated() {
        createUserAluno();
        createUserProfessor();
        Page<UserDto> userDtos = userService.list(new PageableRequestDto(0, 20));
        assertNotNull(userDtos);
        assertFalse(userDtos.getContent().isEmpty());
    }

    @DisplayName("Creates a user and check user created.")
    @Test
    void createUser_ThenCheckFields() {
        UserDto userDto = createUserProfessor();
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
                () -> assertEquals("mypass", userDtoCheck.getPassword())

        );
    }

    @DisplayName("Creates a Professor User Type, then creates a Professor User and check User Type.")
    @Test
    void createUserWhenUserTypeEqualsProfessor_ThenCheckFields() {
        UserDto userDto = createUserProfessor();
        UserDto userDtoCheck = userService.findById(userDto.getUserId());

        assertAll("Check User with User Type Professor",
                () -> assertNotNull(userDtoCheck.getUserType()),
                () -> assertTrue(userDtoCheck.getUserType().getId() > 0),
                () -> assertEquals("Professor", userDtoCheck.getUserType().getName())

        );
    }

    @DisplayName("Creates a Aluno User Type, then creates a Aluno User and check User Type.")
    @Test
    void createUserWhenUserTypeEqualsAluno_ThenCheckFields() {
        UserDto userDto = createUserAluno();
        UserDto userDtoCheck = userService.findById(userDto.getUserId());

        assertAll("Check User with User Type Aluno",
                () -> assertNotNull(userDtoCheck.getUserType()),
                () -> assertTrue(userDtoCheck.getUserType().getId() > 0),
                () -> assertEquals("Aluno", userDtoCheck.getUserType().getName())

        );
    }

    private UserDto createUserProfessor() {
        return createUserSallo(creteUserTypeProfessor());

    }

    private UserDto createUserAluno() {
        return createUserJoao(creteUserTypeAluno());
    }

    private UserDto createUserJoao(UserTypeDto userTypeDto) {
        return userService.save(
          UserFactory.createUserDto("joao.miguel", "joao.miguel@gmail.com", "mypass", userTypeDto)
        );
    }

    private UserDto createUserSallo(UserTypeDto userTypeDto) {
        return userService.save(
          UserFactory.createUserDto("sallo.szrajbman", "sallo.szrajbmanl@hotmail.com", "mypass", userTypeDto)
        );
    }

    private UserTypeDto creteUserTypeProfessor(){
        return userTypeService.save(UserTypeFactory.createUserTypeDto("Professor"));
    }

    private UserTypeDto creteUserTypeAluno(){
        return userTypeService.save(UserTypeFactory.createUserTypeDto("Aluno"));
    }
}