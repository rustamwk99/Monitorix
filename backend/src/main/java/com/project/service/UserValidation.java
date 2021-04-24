package com.project.service;

import com.project.model.MUser;
import com.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserValidation {
    UserRepository userRepository;
    MUser user;
    public boolean isExistAndValid(){
        MUser userStorage = userRepository.findUserByLogin(user.getLogin());
        if (userRepository.findUserByLogin(user.getLogin()) == null){
            return false;
        }
        if (user.getPassword().equals(userStorage.getPassword())){
            return true;
        } else return false;
    }
}
