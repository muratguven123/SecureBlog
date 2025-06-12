package com.SecureBlog.SecureBlog.controller;

import com.SecureBlog.SecureBlog.Entity.User;
import com.SecureBlog.SecureBlog.Service.UserService;
import com.SecureBlog.SecureBlog.dto.User.userResponse;
import com.SecureBlog.SecureBlog.dto.auth.LoginRequest;
import com.SecureBlog.SecureBlog.mapper.usermapper;
import com.SecureBlog.SecureBlog.repos.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class usercontroller {
    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/me")
    @PreAuthorize("hasAnyRole('User','Admin')")
    public User getUser(@AuthenticationPrincipal UserDetails userDetails) {
        return userRepository.findByEmail(userDetails.getUsername()).orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('Admin')")
    public List<User> getAdmin() {
        return userRepository.findAll();
        //Burada amacım admin herkesi döndürsün
    }

    @PostMapping("/register")
    public ResponseEntity<userResponse> register(@RequestBody @Valid userResponse request,usermapper usermapper) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already in use");
        }

       User user= usermapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        User savedUser = userRepository.save(user);

        return ResponseEntity.ok(usermapper.toDto(savedUser));
    }
    @PutMapping("/update")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<userResponse> update(@RequestBody @Valid userResponse request,usermapper usermapper) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already in use");
        }
        User user= usermapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(usermapper.toDto(savedUser));
    }
    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<userResponse> delete(@RequestBody @Valid userResponse request,usermapper usermapper) {
        if (!userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("User Not Found");
        }
        User user= usermapper.toEntity(request);
        userRepository.delete(user);
        return ResponseEntity.ok(usermapper.toDto(user));

    }
}



