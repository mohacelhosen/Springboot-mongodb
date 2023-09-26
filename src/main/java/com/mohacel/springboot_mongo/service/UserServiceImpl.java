package com.mohacel.springboot_mongo.service;

import com.mohacel.springboot_mongo.model.UserModel;
import com.mohacel.springboot_mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository repository;

    @Override
    public UserModel save(UserModel userModel) {
        userModel.setId(null);
        return repository.save(userModel);
    }

    @Override
    public UserModel getUserById(String userId) {
        return repository.findById(userId).orElse(null);
    }

    @Override
    public List<UserModel> getUserByName(String userName) {
        return repository.findByUserName(userName);
    }

    @Override
    public UserModel getUserByEmail(String userEmail) {
        return repository.findByEmail(userEmail).orElse(null);
    }

    @Override
    public UserModel getUserByAcademicId(String academicId){
        List<UserModel> userModelList = repository.findByAcademicId(academicId);
        return  userModelList.get(0);
    }
}
