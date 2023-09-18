package com.mohacel.springboot_mongo.service;

import com.mohacel.springboot_mongo.collection.UserDocument;

import java.util.List;

public interface UserService {
    UserDocument save(UserDocument userDocument);
    public UserDocument getUserById(String userId);
    public List<UserDocument> getUserByName(String userName);
    public UserDocument getUserByEmail(String userEmail);
}
