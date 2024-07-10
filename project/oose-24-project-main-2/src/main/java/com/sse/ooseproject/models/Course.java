package com.sse.ooseproject.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "course")
    private List<RoomOccupancy> roomOccupancies;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollmentList;

    @OneToMany(mappedBy = "course")
    private List<TeachingShift> teachingShiftList;

    @ManyToOne
    @JoinColumn(name = "chair_id")
    private Chair chair;

    // Default constructor
    public Course() {
    }

    // Parameterized constructor
    public Course(String name, List<RoomOccupancy> roomOccupancies, List<Enrollment> enrollmentList, List<TeachingShift> teachingShiftList, Chair chair) {
        this.name = name;
        this.roomOccupancies = roomOccupancies;
        this.enrollmentList = enrollmentList;
        this.teachingShiftList = teachingShiftList;
        this.chair = chair;
    }

    // Getter and Setter for id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for roomOccupancies
    public List<RoomOccupancy> getRoomOccupancies() {
        return roomOccupancies;
    }

    public void setRoomOccupancies(List<RoomOccupancy> roomOccupancies) {
        this.roomOccupancies = roomOccupancies;
    }

    // Getter and Setter for enrollmentList
    public List<Enrollment> getEnrollmentList() {
        return enrollmentList;
    }

    public void setEnrollmentList(List<Enrollment> enrollmentList) {
        this.enrollmentList = enrollmentList;
    }

    // Getter and Setter for teachingShiftList
    public List<TeachingShift> getTeachingShiftList() {
        return teachingShiftList;
    }

    public void setTeachingShiftList(List<TeachingShift> teachingShiftList) {
        this.teachingShiftList = teachingShiftList;
    }

    // Getter and Setter for chair
    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }
}