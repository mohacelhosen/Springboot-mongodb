package com.mohacel.springboot_mongo.service;

import com.mohacel.springboot_mongo.model.PhysicalInfo;
import com.mohacel.springboot_mongo.model.UserModel;
import com.mohacel.springboot_mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsInfoService {
    @Autowired
    private UserRepository userRepository;
    public PhysicalInfo save(String academicId,PhysicalInfo physicalInfo){
        List<UserModel> byAcademicId = userRepository.findByAcademicId(academicId);
        UserModel userModel = byAcademicId.get(0);
        if (userModel !=null){
            physicalInfo.setId(userModel.getId());
            physicalInfo.setAcademicId(userModel.getAcademicId());
            physicalInfo.setFirstName(userModel.getFirstName());
            physicalInfo.setLastName(userModel.getLastName());
            physicalInfo.setUserName(userModel.getUserName());
            physicalInfo.setAge(userModel.getAge());
            physicalInfo.setEmail(userModel.getEmail());
            physicalInfo.setGender(userModel.getGender());
            physicalInfo.setBirthDate(userModel.getBirthDate());
            physicalInfo.setBloodGroup(userModel.getBloodGroup());
            physicalInfo.setPhone(userModel.getPhone());
            physicalInfo.setHobbies(userModel.getHobbies());
            physicalInfo.setAddress(userModel.getAddress());
            return userRepository.save(physicalInfo);

        }
        return null;
    }

    public List<UserModel> getAll(){
        return userRepository.findAll();
    }
}
