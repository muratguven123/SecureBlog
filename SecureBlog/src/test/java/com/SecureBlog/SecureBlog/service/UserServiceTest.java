package com.SecureBlog.SecureBlog.service;

import com.SecureBlog.SecureBlog.Entity.User;
import com.SecureBlog.SecureBlog.Service.UserService;
import com.SecureBlog.SecureBlog.dto.User.userResponse;
import com.SecureBlog.SecureBlog.repos.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldReturnUserById() {
        User user = new User();
        when(userRepository.findById(1)).thenReturn(Optional.of(user));

        userResponse result = userService.getUserByUsername("murat");

        assertEquals("Murat", result.getUsername());
    }
}

