package com.SecureBlog.SecureBlog.mapper;

import com.SecureBlog.SecureBlog.Entity.User;
import com.SecureBlog.SecureBlog.dto.User.userResponse;
import com.SecureBlog.SecureBlog.dto.User.userupdaterequest;
import com.SecureBlog.SecureBlog.dto.auth.LoginRequest;
import org.springframework.stereotype.Component;

@Component
public class usermapper {
    public User toEntity(userResponse userdto) {
        User user = new User();
        user.setUsername(userdto.getUsername());
        user.setPassword(userdto.getPassword());
        user.setEmail(userdto.getEmail());
        return user;
    }
    public userResponse toDto(User user) {
        userResponse userdto = new userResponse();
        userdto.setUsername(user.getUsername());
        userdto.setPassword(user.getPassword());
        userdto.setEmail(user.getEmail());
        return userdto;
    }
    public userupdaterequest toUpdater(User user) {
        userupdaterequest userupdaterequest = new userupdaterequest();
        userupdaterequest.setUsername(user.getUsername());
        userupdaterequest.setPassword(user.getPassword());
        userupdaterequest.setEmail(user.getEmail());
        return userupdaterequest;
    }
    public LoginRequest toLoginRequest(User user) {
        LoginRequest loginrequest = new LoginRequest();
        loginrequest.setUsername(user.getUsername());
        loginrequest.setPassword(user.getPassword());
        loginrequest.setEmail(user.getEmail());
        return loginrequest;
    }
}
