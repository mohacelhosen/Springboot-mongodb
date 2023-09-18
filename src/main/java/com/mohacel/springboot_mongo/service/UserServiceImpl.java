package com.mohacel.springboot_mongo.service;

import com.mohacel.springboot_mongo.collection.UserDocument;
import com.mohacel.springboot_mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository repository;

    @Override
    public UserDocument save(UserDocument userDocument) {
        userDocument.setId(null);
        return repository.save(userDocument);
    }

    @Override
    public UserDocument getUserById(String userId) {
        return repository.findById(userId).get();
    }

    @Override
    public List<UserDocument> getUserByName(String userName) {
        List<UserDocument> documentList = repository.findByUserName(userName);
        return documentList;
    }

    @Override
    public UserDocument getUserByEmail(String userEmail) {
        return repository.findByEmail(userEmail).get();
    }
}
