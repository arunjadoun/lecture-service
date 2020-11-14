package com.learning.utils;

import com.learning.entity.User;
import com.learning.request.UserRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class AppUtils {

    /*public static List<NewsResponse> getNewsResponse(List<News> newsList){
        List<NewsResponse> newsResponseList = new ArrayList<NewsResponse>();
        NewsResponse newsResponse = null;
        for(News news : newsList){
            newsResponse = new NewsResponse();
            newsResponse.setHeadLine(news.getHeadLine());
            newsResponse.setLink(news.getLink());
            newsResponse.setSummary(news.getSummary());
//            newsResponse.setImage(news.getImage());
            newsResponse.setCategory(news.getCategory());
            newsResponseList.add(newsResponse);
        }
        return newsResponseList;
    }*/

    public static User getUser(UserRequest userRequest) throws ParseException {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setMobile(userRequest.getMobile());
        user.setName(userRequest.getName());
        user.setGender(userRequest.getGender());
        user.setUserName(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD");
        user.setDob(simpleDateFormat.parse(userRequest.getDob()));
        return user;
    }
}
