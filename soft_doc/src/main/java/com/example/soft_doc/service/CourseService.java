package com.example.soft_doc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.soft_doc.model.Course;
import com.example.soft_doc.repository.CourseRepository;

import java.util.Date;

@Service
public class CourseService extends AbstractService<Course>{
    @Autowired
    public CourseService(CourseRepository courseRepository) {
        super(courseRepository);
    }

    @Override
    public Course mapCsvToObject(String[] objectCsv) {
        String id = objectCsv[0];
        String courseName = objectCsv[1];
        String courseDescription = objectCsv[2];
        String duration = objectCsv[3];
        String tutour = objectCsv[4];

        return new Course(courseName, courseDescription, duration, tutour);
    }
}
