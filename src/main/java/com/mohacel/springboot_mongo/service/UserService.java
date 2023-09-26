package com.mohacel.springboot_mongo.service;

import com.mohacel.springboot_mongo.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel save(UserModel userModel);
    public UserModel getUserById(String userId);
    public List<UserModel> getUserByName(String userName);
    public UserModel getUserByEmail(String userEmail);
    public UserModel getUserByAcademicId(String academicId);
}
