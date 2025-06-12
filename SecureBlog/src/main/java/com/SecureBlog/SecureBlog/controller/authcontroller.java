package com.SecureBlog.SecureBlog.controller;

import com.SecureBlog.SecureBlog.Service.AuthenticationService;
import com.SecureBlog.SecureBlog.Service.UserService;
import com.SecureBlog.SecureBlog.dto.auth.LoginRequest;
import com.SecureBlog.SecureBlog.dto.auth.RegisterRequest;
import com.SecureBlog.SecureBlog.dto.auth.authresponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class authcontroller {
private final AuthenticationService authenticationService;

@PostMapping("/register")
    public ResponseEntity<authresponse> register(@RequestBody RegisterRequest registerRequest) {
        authresponse response = authenticationService.register(registerRequest);
        return ResponseEntity.ok(response);
}
@PostMapping("/login")
    public ResponseEntity<authresponse> login(@RequestBody LoginRequest loginRequest) {
    authresponse response = authenticationService.login(loginRequest);
    return ResponseEntity.ok(response);
}







}
