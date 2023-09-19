package com.example.coursemanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "course-info")
@Data
public class CourseEntity {

    @Id
    private int id;

    private String name;

    private int fees;

    private String duration;

    private int intake;

    private String status;


}