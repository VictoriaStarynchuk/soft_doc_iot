package com.example.soft_doc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.soft_doc.model.Course;
import com.example.soft_doc.model.Specialization;
import com.example.soft_doc.repository.SpecializationRepository;

import java.util.List;

@Service
public class SpecializationService  extends AbstractService<Specialization>{
    private final CourseService courseService;
    @Autowired
    public SpecializationService(SpecializationRepository specializationRepository, CourseService courseService) {
        super(specializationRepository);
        this.courseService = courseService;
    }

    @Override
    public Specialization mapCsvToObject(String[] objectCsv) {
        String id = objectCsv[0];
        Integer courseid = Integer.parseInt(objectCsv[1]);
        List<Course> listev = courseService.findAll();
        Course course = courseService.getById(Integer.parseInt(objectCsv[1]));
        String specializationName = objectCsv[2];
        String description = (objectCsv[3]);
        return new Specialization(course, specializationName, description);
    }
}
