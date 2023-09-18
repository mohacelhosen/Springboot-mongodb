package com.mohacel.springboot_mongo.service;

import com.mohacel.springboot_mongo.collection.UserDocument;

public interface UserService {
    UserDocument save(UserDocument userDocument);
    public UserDocument getUserById(String userId);
}
