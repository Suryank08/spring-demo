package com.example.mappingdemo.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
//to avoid circular reference use this  annotation::- infinite rcursion::-
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Instructor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id")
    private Integer id;
//to avoid infinite recurrsion we can use @JsonManagedReference(On parent side) and @JsonBackReference(on child side)
    @Column(name = "instructor_name")
    private String name;

    @Column(name = "age")
    private Integer age;
    @ManyToMany(fetch = FetchType.LAZY , cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
  @JoinTable(name = "instructor_course",joinColumns = @JoinColumn(name = "instructor_id"),inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Courses> instructorCourses=new ArrayList<Courses>();

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instructor() {
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
//    //convience method by chad derby
//    public void addInstructorCourses(Courses tempCourse) {
//
//        if (instructorCourses == null) {
//            instructorCourses = new ArrayList<>();
//        }
//
//        instructorCourses.add(tempCourse);
//    }
}
