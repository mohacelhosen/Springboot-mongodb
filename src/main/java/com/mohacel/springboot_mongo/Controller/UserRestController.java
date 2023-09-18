package com.mohacel.springboot_mongo.Controller;

import com.mohacel.springboot_mongo.collection.UserDocument;
import com.mohacel.springboot_mongo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "UserRestController", description = "APIs for User REST controller")
public class UserRestController {
    Logger logger =LoggerFactory.getLogger(UserRestController.class);
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    @Operation(summary = "create new user !!", description = "This is user REST API for create new user, if you provide id it will not use for create user.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Success | OK"),
            @ApiResponse(responseCode = "401", description = "not authorized !!"),
            @ApiResponse(responseCode = "201", description = "new user created !!")

    })
    public ResponseEntity<UserDocument> save(@Valid @RequestBody UserDocument userDocument){
       UserDocument savedUser = userService.save(userDocument);
       return  new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/search/{userId}")
    @Operation(summary = "Get single user", description = "Get single user by their ID")
    public ResponseEntity<UserDocument> getUserById(@PathVariable String userId){
        UserDocument user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/search/username")
    @Operation(summary = "Get single user", description = "Get single user by their user name")
    public ResponseEntity<List<UserDocument>> getUserByUserName(@RequestBody String userName){
        List<UserDocument> documentList = userService.getUserByName(userName);
        return new ResponseEntity<>(documentList, HttpStatus.OK);
    }
    @PostMapping("/search/email")
    @Operation(summary = "Get single user", description = "Get single user by their email")
    public ResponseEntity<UserDocument> getUserByEmail(@RequestParam String userEmail) {
        logger.info("UserRestController::getUserByEmail, " + userEmail);
        String email = userEmail.trim();
        System.out.println(email);
        UserDocument userOptional = userService.getUserByEmail(email);

        if (userOptional != null) {
            return new ResponseEntity<>(userOptional, HttpStatus.OK);
        } else {
            // Handle the case where no user with the given email is found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
