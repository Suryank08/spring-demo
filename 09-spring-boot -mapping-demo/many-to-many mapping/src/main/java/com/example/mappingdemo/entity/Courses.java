package com.example.mappingdemo.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Courses implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "course_name")
    private String courseName;
    @Column(name = "duration")
    private Integer duration;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "instructor_course", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "instructor_id"))
    private List<Instructor> instructorsList=new ArrayList<Instructor>();

    public List<Instructor> getInstructorsList() {
        return instructorsList;
    }

    public void setInstructorsList(List<Instructor> instructorsList) {
        this.instructorsList = instructorsList;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Courses() {
    }

    public Courses(String courseName, Integer duration) {
        this.courseName = courseName;
        this.duration = duration;

    }

    @Override
    public String toString() {
        return "Courses{" +
                "courseName='" + courseName + '\'' +
                ", Duration=" + duration +
                '}';
    }

    //Convience method to remove the error  a detached entity passed to persist error
//    public void addInstructor(Instructor instructor) {
//        if (instructorsList == null) {
//            instructorsList = new ArrayList<>();
//        }
//        instructorsList.add(instructor);
//    }
}
