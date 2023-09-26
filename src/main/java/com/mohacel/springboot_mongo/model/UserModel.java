package com.mohacel.springboot_mongo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserModel {
    @Id
    private String id;
    private String academicId;
    private String firstName;
    private String lastName;
    @Size(min = 5,max = 25, message = "Invalid user name !!")
    private String userName;
    @Email(message = "Email is not valid")
    @NotBlank(message = "Email is required")
    @Indexed(unique=true)
    private String email;
    private String gender;
    private LocalDate birthDate;
    private Integer age;
    private String bloodGroup;
    private String phone;
    private List<String> hobbies;
    private Address address;
}
