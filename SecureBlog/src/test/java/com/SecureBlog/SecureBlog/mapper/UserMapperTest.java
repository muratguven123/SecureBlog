package com.SecureBlog.SecureBlog.mapper;

import com.SecureBlog.SecureBlog.Entity.User;
import com.SecureBlog.SecureBlog.dto.User.userResponse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserMapperTest {

    private final usermapper userMapper = new usermapper();

    @Test
    void shouldMapUserToDto() {
        User user = new User();
        userResponse dto = userMapper.toDto(user);

        assertEquals(user.getEmail(), dto.getEmail());
        assertEquals(user.getUsername(), dto.getUsername());
    }

    @Test
    void shouldMapDtoToUser() {
        userResponse dto = new userResponse();
        User user = userMapper.toEntity(dto);

        assertEquals(dto.getEmail(), user.getEmail());
        assertEquals(dto.getUsername(), user.getUsername());
    }
}

