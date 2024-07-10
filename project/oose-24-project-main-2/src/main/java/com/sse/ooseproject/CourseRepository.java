package com.sse.ooseproject;

import com.sse.ooseproject.models.Chair;
import com.sse.ooseproject.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Find by title
    List<Course> findByTitle(String title);

    // Find by title containing (useful for search functionality)
    List<Course> findByTitleContaining(String title);

    // Find all courses offered by a specific chair
    List<Course> findByChair(Chair chair);

    // Find all courses offered by a chair's ID
    List<Course> findByChairId(Long chairId);

    List<Course> findByStudySubject(String studySubject);

}
