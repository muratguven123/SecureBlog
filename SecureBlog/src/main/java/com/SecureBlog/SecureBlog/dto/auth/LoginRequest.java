package com.SecureBlog.SecureBlog.dto.auth;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LoginRequest {
private String email;
private String username;
private String password;



}
