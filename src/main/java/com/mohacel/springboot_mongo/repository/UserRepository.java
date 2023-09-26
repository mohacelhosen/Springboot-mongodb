package com.mohacel.springboot_mongo.repository;

import com.mohacel.springboot_mongo.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserModel, String> {
    List<UserModel> findByUserName(String userName);
    Optional<UserModel> findByEmail(String userEmail);
    @Query("{'academicId': ?0}")
    List<UserModel> findByAcademicId(String academicId);
}
