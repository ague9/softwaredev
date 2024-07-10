package com.sse.ooseproject.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EnrollmentId implements Serializable {

    @JoinColumn(name = "course_id")
    private Long courseId;

    @JoinColumn(name = "student_id")
    private Long studentId;

    // Default constructor
    public EnrollmentId() {
    }

    // Parameterized constructor
    public EnrollmentId(Long courseId, Long studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

    // Getters and Setters
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrollmentId that = (EnrollmentId) o;
        return Objects.equals(courseId, that.courseId) && Objects.equals(studentId, that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, studentId);
    }
}
