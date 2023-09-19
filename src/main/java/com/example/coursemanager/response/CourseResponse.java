package com.example.coursemanager.response;

import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class CourseResponse {

    private String message;

    private HttpStatus statuscode;

    private Object object;

    public CourseResponse(String message) {
        this.message = message;
    }

    public CourseResponse(String message, HttpStatus statuscode) {
        this.message = message;
        this.statuscode = statuscode;
    }

    public CourseResponse(String message, HttpStatus statuscode, Object object) {
        this.message = message;
        this.statuscode = statuscode;
        this.object = object;
    }


}
