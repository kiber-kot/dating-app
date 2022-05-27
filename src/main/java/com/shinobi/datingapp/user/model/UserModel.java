package com.shinobi.datingapp.user.model;

import com.shinobi.datingapp.user.entity.UserEntity;
import lombok.Data;

@Data
public class UserModel {

    private Long id;

    private String name;

    public static UserModel toModel(UserEntity userEntity){
        var userModel = new UserModel();
        userModel.setId(userEntity.getId());
        userModel.setName(userEntity.getName());
        return userModel;
    }
}
