/*
package com.learning.service;

import com.due.dots.entity.News;
import com.due.dots.enums.Category;
import com.due.dots.repository.NewsRepository;
import com.due.dots.response.BaseResponse;
import com.due.dots.response.NewsResponse;
import com.due.dots.utils.AppUtils;
import com.google.gson.Gson;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class NewsService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    Gson gson = new Gson();

    @Autowired
    private NewsRepository newsRepository;

    public List<NewsResponse> findAll(String category, Integer pageNo, Integer pageSize){
        Page<News> newsList = null;
        Pageable pageable = new PageRequest(pageNo, pageSize, Sort.Direction.DESC, "createdAt");
        if(StringUtils.isEmpty(category)){
            newsList = newsRepository.findAll(pageable);
        }else {
            newsList = newsRepository.findByCategoryContaining(category, pageable);
        }
        return AppUtils.getNewsResponse(newsList.getContent());
    }

    public ResponseEntity<String> saveNews(MultipartFile file, String headLine, String link, String summary, String category) throws FileUploadException, IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try{
            if(StringUtils.isEmpty(category) || Category.valueOf(category)==null){
                BaseResponse baseResponse = new BaseResponse("DD-101", "Invalid Category");
                return new ResponseEntity<String>(gson.toJson(baseResponse), HttpStatus.OK);
            }
            if(StringUtils.isEmpty(fileName) || fileName.contains("..")){
                throw new FileUploadException("File contain invalid path sequence");
            }
            News news = new News();
            news.setHeadLine(headLine);
            news.setLink(link);
            news.setSummary(summary);
            news.setImage(file.getBytes());
            news.setCreatedAt(new Date());
            news.setCategory(category.toUpperCase());
            newsRepository.save(news);
            return new ResponseEntity<String>(gson.toJson(new BaseResponse("200", "SUCCESS")), HttpStatus.OK);
        } catch (FileUploadException e) {
            e.printStackTrace();
            return new ResponseEntity<String>(gson.toJson(new BaseResponse("DD-102", "Error in file upload")), HttpStatus.OK);
        }
    }

}
*/
