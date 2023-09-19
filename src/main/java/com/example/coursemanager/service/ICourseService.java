package com.example.coursemanager.service;

import com.example.coursemanager.model.CourseModel;
import org.springframework.http.ResponseEntity;

public interface ICourseService {

    public ResponseEntity<?> getCourse();

    public String addCourse(CourseModel courseModel);

    public ResponseEntity<?> getCourseById(int id);

    public ResponseEntity<?> deleteCourseById(int id);
}
