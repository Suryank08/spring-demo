package com.example.mappingdemo.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id")
    private Integer id;

    @Column(name = "instructor_name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @OneToOne(mappedBy = "instructor", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private InstructorDetail instructorDetail;

    @OneToMany(fetch = FetchType.EAGER , cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH},mappedBy = "instructor")
    private List<Courses> instructorCourses;

    public List<Courses> getInstructorCourses() {
        return instructorCourses;
    }

    public void setInstructorCourses(List<Courses> instructorCourses) {
        this.instructorCourses = instructorCourses;
    }

    public Instructor(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Instructor() {
    }

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    public void addInstructorCourses(Courses tempCourse) {

        if (instructorCourses == null) {
            instructorCourses = new ArrayList<>();
        }

        instructorCourses.add(tempCourse);

        tempCourse.setInstructor(this);
    }
    @Override
    public String toString() {
        return "Instructor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
