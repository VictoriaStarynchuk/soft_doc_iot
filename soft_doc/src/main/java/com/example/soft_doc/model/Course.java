package com.example.soft_doc.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "course")
public class Course {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "duration")
    private String duration;

    @Basic
    @Column(name = "tutour")
    private String tutour;

    public Course(String courseName, String courseDescription, String duration, String tutour) {
        this.name = courseName;
        this.description = courseDescription;
        this.duration = duration;
        this.tutour = tutour;
    }
    public String[] toCsvFormat() {
        return new String[]{ "COURSE", this.name, this.description, this.duration, this.tutour};
    }

}
