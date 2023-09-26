package com.mohacel.springboot_mongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhysicalInfo extends UserModel{
    private String height;
    private String weight;
}
