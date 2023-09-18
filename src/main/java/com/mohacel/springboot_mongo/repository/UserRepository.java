package com.mohacel.springboot_mongo.repository;

import com.mohacel.springboot_mongo.collection.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserDocument, String> {
    List<UserDocument> findByUserName(String userName);
    Optional<UserDocument> findByEmail(String userEmail);
}
