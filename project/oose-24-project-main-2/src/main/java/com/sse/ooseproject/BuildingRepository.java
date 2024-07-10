package com.sse.ooseproject;

import com.sse.ooseproject.models.Building;
import com.sse.ooseproject.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
}
