package com.example.mappingdemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id")
    private Integer id;

    @Column(name = "instructor_name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @OneToOne(mappedBy = "instructor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private InstructorDetail instructorDetail;

    public Instructor(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Instructor() {
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

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void addInstructorDetail(InstructorDetail instructorDetail) {

        instructorDetail.setInstructor(this);
    }
}
