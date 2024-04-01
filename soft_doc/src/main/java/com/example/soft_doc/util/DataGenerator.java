package com.example.soft_doc.util;

import com.opencsv.CSVWriter;
import org.jeasy.random.EasyRandom;
import com.example.soft_doc.model.Register;
import com.example.soft_doc.model.Course;
import com.example.soft_doc.model.Specialization;
import com.example.soft_doc.model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DataGenerator {
    public static void main(String[] args) throws IOException {
        List<String[]> data = new ArrayList<>();

        generateUserData(data);
        generateCourseData(data);
        generateSpecializationData(data);
        generateRegisterData(data);

        try (CSVWriter writer = new CSVWriter(new FileWriter("data.csv"))) {
            writer.writeAll(data);
        }
    }

    private static void generateUserData(List<String[]> data) {
        EasyRandom generator = new EasyRandom();
        List<User> users = generator.objects(User.class, 500).toList();

        for (User user : users) {
            data.add(user.toCsvFormat());
        }
    }

    private static void generateCourseData(List<String[]> data) {
        EasyRandom generator = new EasyRandom();
        List<Course> courses = generator.objects(Course.class, 500).toList();

        for (Course course : courses) {
            data.add(course.toCsvFormat());
        }
    }

    private static void generateSpecializationData(List<String[]> data) {
        EasyRandom generator = new EasyRandom();
        List<Specialization> specializations = generator.objects(Specialization.class, 500).toList();

        for (Specialization specialization : specializations) {
            data.add(specialization.toCsvFormat());
        }
    }


    private static void generateRegisterData(List<String[]> data) {
        EasyRandom generator = new EasyRandom();
        List<Register> registers = generator.objects(Register.class, 500).toList();

        for (Register register : registers) {
            data.add(register.toCsvFormat());
        }
    }
}
