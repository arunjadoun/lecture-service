package com.learning.response;

import lombok.Data;

@Data
public class BaseResponse {
    private String code;
    private String message;

    /*public BaseResponse(String code, String message, String token) {
        this.code = code;
        this.message = message;
        this.token = token;
    }*/

    public BaseResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
