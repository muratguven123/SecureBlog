package com.SecureBlog.SecureBlog.controller;

import com.SecureBlog.SecureBlog.Entity.User;
import com.SecureBlog.SecureBlog.Service.AdminService;
import com.SecureBlog.SecureBlog.Service.UserService;
import com.SecureBlog.SecureBlog.dto.User.userResponse;
import com.SecureBlog.SecureBlog.mapper.usermapper;
import com.SecureBlog.SecureBlog.repos.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user/admin")
@RestController
@RequiredArgsConstructor
public class admincontroller {
private final AdminService adminService;
private final UserRepository userRepository;
private final usermapper usermapper;
private BCryptPasswordEncoder encoder;

    @GetMapping("/admin")
    @PreAuthorize("hasRole('Admin')")
    public List<User> getAdmin() {
        return userRepository.findAll();
        //Burada amacım admin herkesi döndürsün
    }
    @PostMapping("/register")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<userResponse> registeredbyadmin(@RequestBody @Valid userResponse request, usermapper usermapper) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already in use");
        }

        User user= usermapper.toEntity(request);
        user.setPassword(encoder.encode(request.getPassword()));
        User savedUser = userRepository.save(user);

        return ResponseEntity.ok(usermapper.toDto(savedUser));
    }
    @PutMapping("/update")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<userResponse> updatedbyadmin(@RequestBody @Valid userResponse request,usermapper usermapper) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already in use");
        }
        User user= usermapper.toEntity(request);
        user.setPassword(encoder.encode(request.getPassword()));
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(usermapper.toDto(savedUser));
    }
    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<userResponse> deletedbyadmin(@RequestBody @Valid userResponse request,usermapper usermapper) {
        if (!userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("User Not Found");
        }
        User user= usermapper.toEntity(request);
        userRepository.delete(user);
        return ResponseEntity.ok(usermapper.toDto(user));

    }




}
