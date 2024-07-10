package com.sse.ooseproject;

import com.sse.ooseproject.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // TODO add query methods.
    Optional<Student> findByMatNr(long matNr);
}
