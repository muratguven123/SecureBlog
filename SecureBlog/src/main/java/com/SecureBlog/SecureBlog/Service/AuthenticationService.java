package com.SecureBlog.SecureBlog.Service;

import com.SecureBlog.SecureBlog.Entity.RoleTypes;
import com.SecureBlog.SecureBlog.Entity.User;
import com.SecureBlog.SecureBlog.dto.auth.authresponse;
import com.SecureBlog.SecureBlog.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.SecureBlog.SecureBlog.dto.auth.LoginRequest;
import com.SecureBlog.SecureBlog.dto.auth.RegisterRequest;
import com.SecureBlog.SecureBlog.repos.UserRepository;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public authresponse register(RegisterRequest registerRequest) {
        // 1.Şifreyi encode edilmesi gerekiyor

        String hashedPassword = passwordEncoder.encode(registerRequest.getPassword());

        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword(hashedPassword);
        user.setUsername(registerRequest.getUsername());
        user.setRole(RoleTypes.User);//Burada default role tanımlandı
        userRepository.save(user);

        String token = jwtService.generateToken(user.getEmail());

        return new authresponse(token);
    }
    public authresponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        User user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow(()->new RuntimeException("User not found"));

        String token = jwtService.generateToken(user.getEmail());
        return new authresponse(token);

    }



}
