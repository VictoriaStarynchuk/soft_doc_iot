package com.example.soft_doc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.soft_doc.model.Register;
import com.example.soft_doc.model.Course;
import com.example.soft_doc.model.Specialization;
import com.example.soft_doc.model.User;
import com.example.soft_doc.repository.StorageRepository;

import java.util.List;

@Service
public class DBService {
    @Autowired
    StorageRepository storageRepository;

    SpecializationService specializationService;
    UserService userService;
    RegisterService registerService;
    CourseService courseService;
    @Autowired
    public DBService(SpecializationService specializationService, UserService userService,
                     RegisterService registerService, CourseService courseService) {
        this.courseService = courseService;
        this.registerService = registerService;
        this.specializationService = specializationService;
        this.userService = userService;
    }

    public void dumpCsvToDB(String filepath) {
        List<String[]> data = storageRepository.readAll(filepath);
        data.forEach(entry -> {
            switch (entry[0]) {
                case "USER" -> {
                    User user = userService.mapCsvToObject(entry);
                    userService.saveToDatabase(user);
                }
                case "COURSE" -> {
                    Course course = courseService.mapCsvToObject(entry);
                    courseService.findAll();
                    courseService.saveToDatabase(course);
                }
                case "SPECIALIZATION" -> {
                    Specialization specialization = specializationService.mapCsvToObject(entry);
                    specializationService.saveToDatabase(specialization);
                }
                case "REGISTER" -> {
                    Register register = registerService.mapCsvToObject(entry);
                    registerService.saveToDatabase(register);
                }
            }
        });
    }
}
