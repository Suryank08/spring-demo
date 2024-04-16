package com.example.mappingdemo.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name ="courses" )
public class Courses implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
     private Integer courseId;

    @Column(name = "course_name")
    private String courseName;
    @Column(name = "duration")
    private Integer Duration;
    @ManyToOne(fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getDuration() {
        return Duration;
    }

    public void setDuration(Integer duration) {
        Duration = duration;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Courses() {
    }

    public Courses(String courseName, Integer duration) {
        this.courseName = courseName;
        this.Duration = duration;

    }

    @Override
    public String toString() {
        return "Courses{" +
                "courseName='" + courseName + '\'' +
                ", Duration=" + Duration +
                '}';
    }
}
