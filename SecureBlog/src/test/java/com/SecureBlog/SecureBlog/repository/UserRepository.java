package com.SecureBlog.SecureBlog.repository;

import com.SecureBlog.SecureBlog.Entity.User;
import com.SecureBlog.SecureBlog.repos.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldFindByEmail() {
        User user = new User();
        userRepository.save(user);

        Optional<User> result = userRepository.findByEmail("test@mail.com");
        assertTrue(result.isPresent());
    }
}

