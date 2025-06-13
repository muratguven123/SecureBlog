package com.SecureBlog.SecureBlog.Service;

import com.SecureBlog.SecureBlog.Entity.User;
import com.SecureBlog.SecureBlog.dto.User.userResponse;
import com.SecureBlog.SecureBlog.dto.User.userupdaterequest;
import com.SecureBlog.SecureBlog.dto.post.postresponse;
import com.SecureBlog.SecureBlog.mapper.usermapper;
import com.SecureBlog.SecureBlog.repos.PostRepository;
import com.SecureBlog.SecureBlog.repos.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdminService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final usermapper usermapper;


    public List<userResponse> getAllUser(){
        List<User> users = userRepository.findAll();
        return users.stream().map(usermapper::toDto).toList();
    }
    public userResponse getUserById(int id){
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        return usermapper.toDto(user);
    }
    public userupdaterequest updateUser(userupdaterequest userupdaterequest){
        User  user = userRepository.findById(userupdaterequest.getId()).orElseThrow(()->new RuntimeException("User not found"));
        user.setUsername(userupdaterequest.getUsername());
        user.setEmail(userupdaterequest.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user=  userRepository.save(user);
        return usermapper.toUpdater(user);
    }
    public void deleteUser(userResponse userResponse){
        User user = userRepository.findById(userResponse.getId()).orElseThrow(()->new RuntimeException("User not found"));
        userRepository.delete(user);
    }


}
