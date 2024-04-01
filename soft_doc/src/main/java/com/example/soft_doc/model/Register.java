package com.example.soft_doc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jeasy.random.EasyRandom;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "register_table")
public class Register {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;


    @Basic
    @Column(name = "register_date", nullable = false)
    private String registerDate;

    public Register(User user, Course course,  String registerDate) {
        this.user = user;
        this.course = course;
        this.registerDate = registerDate;
    }
    public String[] toCsvFormat() {
        Integer userId = generateRandomId();
        Integer courseId = generateRandomId();

        return new String[]{
                "REGISTER",
                userId.toString(),
                courseId.toString(),
                this.registerDate
        };
    }
    private Integer generateRandomId() {
        EasyRandom generator = new EasyRandom();
        generator.setSeed(System.nanoTime());
        return generator.nextInt(1, 201);
    }
}
