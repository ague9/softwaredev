package com.sse.ooseproject.models;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "teachingShift")

public class TeachingShift {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    // Default constructor
    public TeachingShift() {
    }

    // Parameterized constructor
    public TeachingShift(Course course, Employee employee) {
        this.course = course;
        this.employee = employee;
    }

    // Getter and Setter for id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getter and Setter for course
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    // Getter and Setter for employee
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

