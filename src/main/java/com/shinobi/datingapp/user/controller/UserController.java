package com.shinobi.datingapp.user.controller;

import com.shinobi.datingapp.user.entity.UserEntity;
import com.shinobi.datingapp.user.exception.UserException;
import com.shinobi.datingapp.user.model.UserModel;
import com.shinobi.datingapp.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userRepository;

    @GetMapping("/get")
    public Object getUsers(){
        return userRepository.getUsers();
    }

    @PostMapping("/save")
    public UserModel registrationUser(@RequestBody UserEntity userEntity){
        try {
            return userRepository.saveUser(userEntity);
        } catch (UserException e) {
            return new UserModel();
        }
    }

    @GetMapping("/reg")
    public String reg(){
        return "Привет";
    }
}
