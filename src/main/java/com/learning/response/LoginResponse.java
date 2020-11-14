package com.learning.response;

import lombok.Data;

@Data
public class LoginResponse extends BaseResponse{
    private String token;
    private String userName;

    public LoginResponse(String code, String message, String userName) {
        super(code, message);
        this.userName = userName;
        this.token = System.currentTimeMillis()+"";
    }

}
