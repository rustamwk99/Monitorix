package com.project.controller;

import com.project.model.MUser;
//import com.project.repository.UserRepository;
import com.project.repository.UserRepository;
import com.project.service.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.WebSession;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {
    static String data = "";
    MUser authUser = new MUser();
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @RequestMapping("/login")
    public boolean login(@RequestBody MUser user,HttpSession session,
                         RedirectAttributes redirectAttributes) {
        MUser userStorage = userRepository.findUserByLogin(user.getLogin());
        if (userRepository.findUserByLogin(user.getLogin()) == null){
            return false;
        }
        if (bCryptPasswordEncoder.matches(user.getPassword(),userStorage.getPassword()) || user.getPassword().equals(userStorage.getPassword())){
           session.setAttribute("test","test");
           data=userStorage.getLogin();
           return true;
        } else return false;
    }

    @RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        return () ->  new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
    }




}
