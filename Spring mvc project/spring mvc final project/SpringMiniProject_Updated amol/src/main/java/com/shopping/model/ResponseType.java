package com.shopping.model;


import org.springframework.stereotype.Component;

@Component
public class ResponseType {

    private String message;
    private Object data;
    private String httpStatus;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }

    public ResponseType(String message, Object data, String httpStatus) {
        this.message = message;
        this.data = data;
        this.httpStatus = httpStatus;
    }
}
