package com.learning.controller;

import com.google.gson.Gson;
import com.learning.request.LoginRequest;
import com.learning.request.UserRequest;
import com.learning.response.BaseResponse;
import com.learning.service.UserService;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class AppController {

    Logger logger = LoggerFactory.getLogger(AppController.class);

    Gson gson = new Gson();

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/news")
    public ResponseEntity<String> createNote(@RequestBody String link)  {
        logger.info("Request received for adding news");
//        return newsService.saveNews(file, headLine, link, summary, category);
        return new ResponseEntity<String>(HttpStatus.OK);
    }


    @CrossOrigin(origins = "https://65.0.190.55:3000")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest)  {
        logger.info("Request received for adding news");
//        return newsService.saveNews(file, headLine, link, summary, category);
        return userService.login(loginRequest);
//        return new ResponseEntity<String>(gson.toJson(new BaseResponse("200", "SUCCESS", "dummy")), HttpStatus.OK);

//        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "https://65.0.190.55:3000")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRequest user)  {
        logger.info("Request received for adding news");
        return userService.saveUser(user);
//        return newsService.saveNews(file, headLine, link, summary, category);
//        return new ResponseEntity<String>(gson.toJson(new BaseResponse("200", "SUCCESS", "dummy")), HttpStatus.OK);

//        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @GetMapping(value = "/news")
    public ResponseEntity<String> getAllNotes(@RequestParam(required = false) String category, @RequestParam Integer pageNo, @RequestParam  Integer pageSize) {
        logger.info("fetching all news with category {}", category);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
