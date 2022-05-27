package com.shinobi.datingapp.user.service;

import com.shinobi.datingapp.user.entity.UserEntity;
import com.shinobi.datingapp.user.exception.UserException;
import com.shinobi.datingapp.user.model.UserModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserEntity> getUsers();

    UserModel saveUser(UserEntity userEntity) throws UserException;

    UserEntity getByLogin(String login);
}
