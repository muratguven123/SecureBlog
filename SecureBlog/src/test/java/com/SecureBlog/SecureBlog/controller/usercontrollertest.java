package com.SecureBlog.SecureBlog.controller;

import com.SecureBlog.SecureBlog.Entity.User;
import com.SecureBlog.SecureBlog.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import static java.lang.reflect.Array.get;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class usercontrollertest {

    @Autowired
     private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void shouldReturnUser() throws Exception {
        User user = new User();
        when(userService.getUserByUsername("murat")).getMock();

        mockMvc.perform((RequestBuilder) get("/users/1"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.username").value("Murat"));
    }

    private Object get(String path) {
        return mockMvc;
    }
}
