package com.sse.ooseproject.models;

import jakarta.persistence.*;
@Entity
@Table(name = "student")
public class Student extends Person {
    // Note: This class does not need its own id attribute as that will be derived.
    private long matNr;
    private String studySubject;


    public Student() {
        super();  // Calls the default constructor of Person
    }

    public Student(long matNr, String studySubject, String firstName, String lastName, String email, University university) {
        super(firstName, lastName, email, university);  // Calls the parameterized constructor of Person
        this.matNr = matNr;
        this.studySubject = studySubject;
    }


    public long getMatNr() {
        return matNr;
    }
    public void setMatNr(long matNr) {
        this.matNr = matNr;
    }
    public String getStudySubject() {
        return studySubject;
    }
    public void setStudySubject(String studySubject) {
        this.studySubject = studySubject;
    }

}
