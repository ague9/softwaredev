package com.sse.ooseproject.models;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employee")


public class Employee extends Person{
    private long staffNr;
    private boolean isProfessor;

    @OneToMany(mappedBy = "employee")
    private List<TeachingShift> teachingShiftList;

    @OneToMany(mappedBy = "owner")
    private List<Chair> chairList;

    public Employee() {
        super();  // Calls the default constructor of Person
    }

    public Employee(long staffNr, boolean isProfessor, String firstName, String lastName, String email, University university ) {
        super(firstName, lastName, email, university);  // Calls the parameterized constructor of Person
        this.staffNr = staffNr;
        this.isProfessor = isProfessor;
    }

    // Getter and Setter for staffNr
    public long getStaffNr() {
        return staffNr;
    }

    public void setStaffNr(long staffNr) {
        this.staffNr = staffNr;
    }

    // Getter and Setter for isProfessor
    public boolean isProfessor() {
        return isProfessor;
    }

    public void setProfessor(boolean professor) {
        isProfessor = professor;
    }

    // Getter and Setter for teachingShiftList
    public List<TeachingShift> getTeachingShiftList() {
        return teachingShiftList;
    }

    public void setTeachingShiftList(List<TeachingShift> teachingShiftList) {
        this.teachingShiftList = teachingShiftList;
    }

    // Getter and Setter for chairList
    public List<Chair> getChairList() {
        return chairList;
    }

    public void setChairList(List<Chair> chairList) {
        this.chairList = chairList;
    }
}
