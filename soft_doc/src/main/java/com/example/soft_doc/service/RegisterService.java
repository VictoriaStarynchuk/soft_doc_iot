package com.example.soft_doc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.soft_doc.model.Course;
import com.example.soft_doc.model.Register;
import com.example.soft_doc.model.Specialization;
import com.example.soft_doc.model.User;
import com.example.soft_doc.repository.RegisterRepository;

import java.util.List;

@Service
public class RegisterService  extends AbstractService<Register>{
    private final UserService userService;
    private final CourseService courseService;
    @Autowired
    public RegisterService(RegisterRepository registerRepository,  UserService userService,
                        CourseService courseService) {
        super(registerRepository);
        this.userService = userService;
        this.courseService = courseService;
    }

    @Override
    public Register mapCsvToObject(String[] objectCsv) {
        String id = objectCsv[0];
        List<User> listev = userService.findAll();
        User user = userService.getById(Integer.parseInt(objectCsv[1]));
        Course course = courseService.getById(Integer.parseInt(objectCsv[2]));
        String registerDate = objectCsv[3];
        return new Register(user,course, registerDate);
    }
}
