package com.SecureBlog.SecureBlog.dto.auth;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterRequest {
    private String email;
    private String password;
    private String confirmPassword;
    private String username;
}
