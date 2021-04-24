package com.project.controller;

import com.project.model.MUser;
import com.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class RegistrationController {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean saveUser(MUser user){
        MUser userStorage = userRepository.findUserByLogin(user.getLogin());
        if (userStorage != null){
            return false;
        }
        user.setRole("USER");
        userRepository.save(user);
        return true;

    }

    @RequestMapping("/registration")
    public boolean addUser(@RequestBody MUser user) {

        if (user.getPassword().equals(user.getConfirmPassword())){
            MUser userStorage = userRepository.findUserByLogin(user.getLogin());
            if (userStorage == null){
                user.setRole("USER");
                user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                userRepository.save(user);
                return true;
            }

        } else return false;
        return false;
    }

}
