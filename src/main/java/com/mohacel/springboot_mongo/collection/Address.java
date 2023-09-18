package com.mohacel.springboot_mongo.collection;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class Address {
    private String id;
    private String country;
    private String city;
    private Integer postalCode;
    private String streetAddress;
}
