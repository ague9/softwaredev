package com.sse.ooseproject;

import com.sse.ooseproject.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // TODO add query methods.
    Optional<Employee> findByStaffNr(long staffNr);
}
