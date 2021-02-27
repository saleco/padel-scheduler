package com.padel.scheduler.user.dto;

import com.padel.scheduler.usertype.dto.UserTypeDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(name = "User")
public class UserDto {

    @Schema(description = "User unique identification", example = "123456", required = true)
    private Integer userId;

    @Schema(description = "User username", example = "myusername", required = true)
    private String username;

    @Schema(description = "User email", example = "myusername@gmail.com", required = true)
    private String email;

    @Schema(description = "User Password", example = "dasldkaljk131231", required = true, hidden = true)
    private String password;

    @Schema(description = "User creation date and time", example = "2020-10-10 12:00:00", required = true)
    private LocalDateTime createTime;

    @Schema(description = "User Type", example = "Aluno, Professor", required = true)
    private UserTypeDto userType;
}
