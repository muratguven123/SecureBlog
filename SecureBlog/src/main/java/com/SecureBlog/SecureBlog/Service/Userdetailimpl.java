package com.SecureBlog.SecureBlog.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.SecureBlog.SecureBlog.repos.UserRepository;
@Service
@RequiredArgsConstructor
public class Userdetailimpl implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Kullanıcı Bulunamadı"+username));
    }
}
