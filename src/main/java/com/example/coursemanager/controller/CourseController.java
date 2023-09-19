package com.example.coursemanager.controller;

import com.example.coursemanager.model.CourseModel;
import com.example.coursemanager.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course/api")
public class CourseController {

    @Autowired
    ICourseService iCourseService;

    @GetMapping("/getallcourse")
    public ResponseEntity<?> getCourse(){

        iCourseService.deleteCourseById(12);
        return iCourseService.getCourse();

    }


    @PostMapping("/addcourse")
    public String addCourse(@RequestBody CourseModel courseModel)
    {
        iCourseService.addCourse(courseModel);
        return "Course Added : ";
    }

    @GetMapping("/getcoursebyid/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id){

        return iCourseService.getCourseById(id);
    }
    @GetMapping("/deletecoursebyid/{id}")


    public ResponseEntity<?> deleteCourseById(@PathVariable int id){


        return iCourseService.deleteCourseById(id);
    }
}
