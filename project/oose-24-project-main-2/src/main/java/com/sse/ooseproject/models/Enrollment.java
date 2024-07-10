package com.sse.ooseproject.models;

import jakarta.persistence.*;

@Entity
@Table(name = "enrollment")
public class Enrollment {

    @EmbeddedId
    private EnrollmentId id;

    @ManyToOne
    @MapsId("course_id")
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    private Student student;

    private String semester;

    // Default constructor
    public Enrollment() {
        this.id = new EnrollmentId();
    }

    // Parameterized constructor
    public Enrollment(Course course, Student student, String semester) {
        this.course = course;
        this.student = student;
        this.semester = semester;
        this.id = new EnrollmentId(course.getId(), student.getId());
    }

    // Getters and Setters
    public EnrollmentId getId() {
        return id;
    }

    public void setId(EnrollmentId id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
