package com.sse.ooseproject.models;

import com.sse.ooseproject.InstituteRepository;
import com.sse.ooseproject.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentValidator {

    private final StudentRepository studentRepository;
    private final InstituteRepository instituteRepository;

    @Autowired
    public StudentValidator(StudentRepository studentRepository, InstituteRepository instituteRepository) {
        this.studentRepository = studentRepository;
        this.instituteRepository = instituteRepository;
    }

    public void validateStudent(Student student) throws StudentValidationException {
        if (student.getFirstName() == null || student.getFirstName().isEmpty()) {
            throw new StudentValidationException("First name is required.");
        }
        if (student.getLastName() == null || student.getLastName().isEmpty()) {
            throw new StudentValidationException("Last name is required.");
        }
        if (student.getEmail() == null || student.getEmail().isEmpty() || !student.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new StudentValidationException("A valid email is required.");
        }
        if (student.getMatNr() <= 0) {
            throw new StudentValidationException("A valid matriculation number is required.");
        }
        if (studentRepository.findByMatNr(student.getMatNr()).isPresent()) {
            throw new StudentValidationException("Matriculation number already exists.");
        }
        if (student.getStudySubject() == null || student.getStudySubject().isEmpty() || !instituteRepository.existsByStudySubject(student.getStudySubject())) {
            throw new StudentValidationException("A valid study subject is required.");
        }
    }
}
