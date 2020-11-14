package com.learning.controller;

import com.google.gson.Gson;
import com.learning.response.BaseResponse;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class AppController {

    Logger logger = LoggerFactory.getLogger(AppController.class);

    Gson gson = new Gson();

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/news")
    public ResponseEntity<String> createNote(@RequestBody String link)  {
        logger.info("Request received for adding news");
//        return newsService.saveNews(file, headLine, link, summary, category);
        return new ResponseEntity<String>(HttpStatus.OK);
    }


    @CrossOrigin(origins = "http://15.206.68.72:3000")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody String link)  {
        logger.info("Request received for adding news");
//        return newsService.saveNews(file, headLine, link, summary, category);
        return new ResponseEntity<String>(gson.toJson(new BaseResponse("200", "SUCCESS", "dummy")), HttpStatus.OK);

//        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @GetMapping(value = "/news")
    public ResponseEntity<String> getAllNotes(@RequestParam(required = false) String category, @RequestParam Integer pageNo, @RequestParam  Integer pageSize) {
        logger.info("fetching all news with category {}", category);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}
