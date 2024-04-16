package com.example.mappingdemo.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "instructor_details")
public class InstructorDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Instructor_detail_id")
    private Integer instructorDetailsId;

    @Column(name = "hobby")
    private String hobby;

    @Column(name = "qualification")
    private String qualification;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public InstructorDetail() {
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public InstructorDetail(String hobby, String qualification) {
        this.hobby = hobby;
        this.qualification = qualification;
    }


    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                ", hobby='" + hobby + '\'' +
                ", qualification='" + qualification + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}
