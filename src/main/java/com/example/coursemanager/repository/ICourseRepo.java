package com.example.coursemanager.repository;

import com.example.coursemanager.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepo extends JpaRepository <CourseEntity,Integer>{
}
