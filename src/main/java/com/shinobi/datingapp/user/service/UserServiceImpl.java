package com.shinobi.datingapp.user.service;

import com.shinobi.datingapp.user.entity.UserEntity;
import com.shinobi.datingapp.user.exception.UserException;
import com.shinobi.datingapp.user.model.UserModel;
import com.shinobi.datingapp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }

    public UserModel saveUser(UserEntity userEntity) throws UserException {
        if(userEntity == null){
            throw new UserException("Пустой json");
        }
        userRepository.save(userEntity);
        return UserModel.toModel(userEntity);
    }

    @Override
    public UserEntity getByLogin(String login){
        if(login == null){
            return null;
        }
        return userRepository.findByLogin(login);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        var user = getByLogin(login);
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), true, true, true, true, new HashSet<>());
    }


}
