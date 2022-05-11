package com.vitu.user.request.manager.web.dto;

import com.vitu.user.request.manager.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    private Long id;
    private String name;
    @Email(message = "email not valid!")
    private String email;
    @NotBlank(message = "password cannot be null or empty")
    private String password;
    private Role role;
}
