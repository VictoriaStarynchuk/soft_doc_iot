package com.example.soft_doc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.example.soft_doc.service.DBService;
@SpringBootApplication
public class SoftDocApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SoftDocApplication.class, args);
        context.getBean(DBService.class).dumpCsvToDB("data.csv");
    }

}
