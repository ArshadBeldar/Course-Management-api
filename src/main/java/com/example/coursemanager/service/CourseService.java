package com.example.coursemanager.service;

import com.example.coursemanager.entity.CourseEntity;
import com.example.coursemanager.model.CourseModel;
import com.example.coursemanager.repository.ICourseRepo;
import com.example.coursemanager.response.CourseResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CourseService implements ICourseService{
    @Autowired
    ICourseRepo iCourseRepo;

    @Override
    public ResponseEntity<?> getCourse() {

        return new ResponseEntity<>(new CourseResponse("Getting All Data : ",HttpStatus.FOUND,iCourseRepo.findAll()),HttpStatus.FOUND);
    }

    @Override
    public String addCourse(CourseModel courseModel) {
        CourseEntity courseEntity = new CourseEntity();
        BeanUtils.copyProperties(courseModel,courseEntity);

        iCourseRepo.save(courseEntity);
        System.out.println(courseEntity.toString());
        return null;
    }

    @Override
    public ResponseEntity<?> getCourseById(int id) {

        Optional<CourseEntity> courseEntity = iCourseRepo.findById(id);
        if (courseEntity.isPresent()){

            return new ResponseEntity<>(new CourseResponse("Data Found By Given ID : ",HttpStatus.FOUND,courseEntity),HttpStatus.FOUND);

        }
        else {

            return new ResponseEntity<>(new CourseResponse("Data Found By Given ID : ",HttpStatus.BAD_REQUEST),HttpStatus.FOUND);

        }
    }

    @Override
    public ResponseEntity<?> deleteCourseById(int id) {

        Optional<CourseEntity> courseEntity = iCourseRepo.findById(id);
        if (courseEntity.isPresent())
        {
            iCourseRepo.deleteById(id);
            return new ResponseEntity<>(new CourseResponse("Product Deleted successfully : ",HttpStatus.ACCEPTED),HttpStatus.FOUND);
        }
        else {
            return new ResponseEntity<>(new CourseResponse("Product Not Found in Data Base by Given Id !!!!!"),HttpStatus.BAD_REQUEST);
        }
    }
}
