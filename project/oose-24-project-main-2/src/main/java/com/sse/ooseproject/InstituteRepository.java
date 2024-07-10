package com.sse.ooseproject;


import com.sse.ooseproject.models.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstituteRepository extends JpaRepository<Institute, Long> {

    boolean existsByStudySubject(String studySubject);

    // Find by name
    List<Institute> findByName(String name);

    // Find by name containing (useful for search functionality)
    List<Institute> findByNameContaining(String name);

    // Find all institutes sorted by name
    List<Institute> findAllByOrderByNameAsc();
}

