package com.padel.scheduler.user.controller;

import com.padel.scheduler.base.dto.PageableRequestDto;
import com.padel.scheduler.base.services.CrudService;
import com.padel.scheduler.user.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "Users", description = "Users Management API")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final CrudService<UserDto> userService;

    @Operation(summary = "Retrieves a Page of Users")
    @GetMapping
    public Page<UserDto> list(@ParameterObject @Valid PageableRequestDto pageableRequestDto) {
        return userService.list(pageableRequestDto);
    }
}
