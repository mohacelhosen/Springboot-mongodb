package com.mohacel.springboot_mongo.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDocument {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String gender;
    private String birthDate;
    private String age;
    private String bloodGroup;
    private String phone;
    private Address address;
}