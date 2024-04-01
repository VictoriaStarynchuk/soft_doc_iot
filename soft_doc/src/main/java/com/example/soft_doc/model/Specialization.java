package com.example.soft_doc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jeasy.random.EasyRandom;
import com.example.soft_doc.model.Course;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "specialization")
public class Specialization {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Basic
    @Column(name = "specialization_Name")
    private String specializationName;

    @Basic
    @Column(name = "description")
    private String description;

    public Specialization(Course course, String specializationName, String description) {
        this.course = course;
        this.specializationName = specializationName;
        this.description = description;
    }

    public String[] toCsvFormat() {
        Integer courseId = generateRandomId();
        return new String[]{
                "SPECIALIZATION",
                courseId.toString(),
                this.specializationName,
                this.description
        };
    }

    private Integer generateRandomId() {
        EasyRandom generator = new EasyRandom();
        generator.setSeed(System.nanoTime());
        return generator.nextInt(1, 201);
    }
}
