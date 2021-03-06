package com.learning.service;

import com.google.gson.Gson;
import com.learning.entity.User;
import com.learning.repository.UserRepository;
import com.learning.request.LoginRequest;
import com.learning.request.UserRequest;
import com.learning.response.BaseResponse;
import com.learning.response.LoginResponse;
import com.learning.utils.AppUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    Gson gson = new Gson();

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> saveUser(UserRequest userRequest){
        try {
            User user = AppUtils.getUser(userRequest);
            userRepository.save(user);
        } catch (ParseException e) {
            logger.error("unable to parse user's dob {}", e.getMessage());
            return new ResponseEntity<String>(gson.toJson(new BaseResponse("DD-103", "Error in parsing dob")), HttpStatus.BAD_REQUEST);
        } catch (Exception e){
            logger.error("unable to add user {}", e.getMessage());
            return new ResponseEntity<String>(new BaseResponse("DD-104", "something went wrong").toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>(gson.toJson(new BaseResponse("200", "SUCCESS")), HttpStatus.OK);
    }

    public ResponseEntity<String> login(LoginRequest loginRequest){
        try {
            User user = userRepository.findByUserName(loginRequest.getUsername());
            LoginResponse loginResponse = new LoginResponse("200", "SUCCESS", user.getUserName());
            return new ResponseEntity<String>(gson.toJson(loginResponse), HttpStatus.OK);
        }  catch (Exception e){
            logger.error("unable to add user {}", e.getMessage());
            return new ResponseEntity<String>(new BaseResponse("DD-104", "something went wrong").toString(), HttpStatus.BAD_REQUEST);
        }
    }
}
