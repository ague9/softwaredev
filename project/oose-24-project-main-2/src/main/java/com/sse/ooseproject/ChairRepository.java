package com.sse.ooseproject;

import com.sse.ooseproject.models.Chair;
import com.sse.ooseproject.models.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChairRepository extends JpaRepository<Chair, Long> {

    // Find by name
    List<Chair> findByName(String name);

    // Find by name containing (useful for search functionality)
    List<Chair> findByNameContaining(String name);

    // Find all chairs in a specific institute
    List<Chair> findByInstitute(Institute institute);

    // Find all chairs in an institute by the institute's ID
    List<Chair> findByInstituteId(Long instituteId);

    // Find all chairs sorted by name
    List<Chair> findAllByOrderByNameAsc();
}