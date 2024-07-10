package com.sse.ooseproject.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "chair")

public class Chair extends OrganizationalUnit {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "institute_id")
    private Institute institute;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee owner;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToMany(mappedBy = "course_id")
    private List<Course> courseList;


    // Default constructor
    public Chair() {
    }

    // Parameterized constructor
    public Chair(String name, Institute institute, Employee owner, Building building, List<Course> courseList) {
        this.name = name;
        this.institute = institute;
        this.owner = owner;
        this.building = building;
        this.courseList = courseList;
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

    // Getter and Setter for institute
    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    // Getter and Setter for owner
    public Employee getOwner() {
        return owner;
    }

    public void setOwner(Employee owner) {
        this.owner = owner;
    }

    // Getter and Setter for building
    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    // Getter and Setter for courseList
    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

}