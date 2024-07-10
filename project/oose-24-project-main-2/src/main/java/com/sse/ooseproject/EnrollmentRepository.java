package com.sse.ooseproject;

import com.sse.ooseproject.models.Course;
import com.sse.ooseproject.models.Enrollment;
import com.sse.ooseproject.models.EnrollmentId;
import com.sse.ooseproject.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, EnrollmentId> {
    List<Enrollment> findByStudentAndSemester(Student student, String semester);

    @Transactional
    void deleteByStudentAndCourseAndSemester(Student student, Course course, String semester);
}

