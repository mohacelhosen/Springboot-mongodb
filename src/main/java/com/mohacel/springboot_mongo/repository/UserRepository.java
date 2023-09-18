package com.mohacel.springboot_mongo.repository;

import com.mohacel.springboot_mongo.collection.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDocument, String> {
}
