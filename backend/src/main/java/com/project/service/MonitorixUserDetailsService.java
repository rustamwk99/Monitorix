package com.project.service;

import com.project.model.MUser;
import com.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MonitorixUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        MUser mUser = userRepository.findUserByLogin(login);
        if(mUser == null){
            throw new UsernameNotFoundException("User not exist" + login);
        }
        UserDetails userDetails = User.builder()
                .username(mUser.getLogin())
                .password(mUser.getPassword())
                .roles(mUser.getRole())
                .build();
        return userDetails;
    }
}
