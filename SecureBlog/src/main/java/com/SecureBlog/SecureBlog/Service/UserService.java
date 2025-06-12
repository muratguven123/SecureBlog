package com.SecureBlog.SecureBlog.Service;

import com.SecureBlog.SecureBlog.dto.User.userResponse;
import com.SecureBlog.SecureBlog.dto.User.userupdaterequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.SecureBlog.SecureBlog.repos.UserRepository;
import com.SecureBlog.SecureBlog.Entity.User;
import com.SecureBlog.SecureBlog.mapper.usermapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserService implements UserDetails{
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

    private  UserRepository userRepository;
    private usermapper usermapper;
    private userupdaterequest userupdaterequest;
   private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();



    public List<userResponse> getAllUser(){
        List<User> users = userRepository.findAll();
        return users.stream().map(usermapper::toDto).toList();
    }

    public userResponse getUserById(int id){
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        return usermapper.toDto(user);
    }
    public userResponse getUserByEmail(String email){
        User user = userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("User not found"));
        return usermapper.toDto(user);
    }
    public userResponse getUserByUsername(String username){
        User user = userRepository.findByUsername(username).orElseThrow(()->new RuntimeException("User not found"));
        return usermapper.toDto(user);
    }
    public userResponse addUser(userResponse userResponse){
        User user = usermapper.toEntity(userResponse);
        User savedUser = userRepository.save(user);
        return usermapper.toDto(savedUser);
    }
    public userupdaterequest updateUser(userupdaterequest userupdaterequest){
        User  user = userRepository.findById(userupdaterequest.getId()).orElseThrow(()->new RuntimeException("User not found"));
        user.setUsername(userupdaterequest.getUsername());
        user.setEmail(userupdaterequest.getEmail());
        user.setPassword(encoder.encode(user.getPassword()));
        user=  userRepository.save(user);

        return usermapper.toUpdater(user);
    }
    public void deleteUser(userResponse userResponse){
        User user = userRepository.findById(userResponse.getId()).orElseThrow(()->new RuntimeException("User not found"));
        userRepository.delete(user);
    }
}