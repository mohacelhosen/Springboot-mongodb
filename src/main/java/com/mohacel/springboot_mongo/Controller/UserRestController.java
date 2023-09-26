package com.mohacel.springboot_mongo.Controller;

import com.mohacel.springboot_mongo.model.PhysicalInfo;
import com.mohacel.springboot_mongo.model.UserModel;
import com.mohacel.springboot_mongo.service.UserDetailsInfoService;
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
    @Autowired
    private UserDetailsInfoService detailsInfoService;

    @PostMapping("/save")
    @Operation(summary = "create new user !!", description = "This is user REST API for create new user, if you provide id it will not use for create user.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Success | OK"),
            @ApiResponse(responseCode = "401", description = "not authorized !!"),
            @ApiResponse(responseCode = "201", description = "new user created !!")

    })
    public ResponseEntity<UserModel> save(@Valid @RequestBody UserModel userModel){
       UserModel savedUser = userService.save(userModel);
       return  new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/search/{userId}")
    @Operation(summary = "Get single user", description = "Get single user by their ID")
    public ResponseEntity<UserModel> getUserById(@PathVariable String userId){
        UserModel user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/search/username")
    @Operation(summary = "Get single user", description = "Get single user by their user name")
    public ResponseEntity<List<UserModel>> getUserByUserName(@RequestBody String userName){
        List<UserModel> documentList = userService.getUserByName(userName);
        return new ResponseEntity<>(documentList, HttpStatus.OK);
    }
    @PostMapping("/search/email")
    @Operation(summary = "Get single user", description = "Get single user by their email")
    public ResponseEntity<UserModel> getUserByEmail(@RequestParam String userEmail) {
        logger.info("UserRestController::getUserByEmail, " + userEmail);
        String email = userEmail.trim();
        System.out.println(email);
        UserModel userOptional = userService.getUserByEmail(email);

        if (userOptional != null) {
            return new ResponseEntity<>(userOptional, HttpStatus.OK);
        } else {
            // Handle the case where no user with the given email is found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/search/id")
    public ResponseEntity<?> userByAcademicId(@RequestParam String academicId){
        UserModel user = userService.getUserByAcademicId(academicId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/complete/{academicId}")
    public ResponseEntity<?> savePhysicalInfo(@PathVariable String academicId, @RequestBody PhysicalInfo physicalInfo){
        PhysicalInfo completeIfo = detailsInfoService.save(academicId,physicalInfo);
        return new ResponseEntity<>(completeIfo, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<?> allUserCompleteInfo(){
        List<UserModel> list = detailsInfoService.getAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }



}
