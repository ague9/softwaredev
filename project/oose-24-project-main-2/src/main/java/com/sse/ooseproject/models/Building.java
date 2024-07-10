package com.sse.ooseproject.models;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "building")

public class Building {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "buildings")
    private List<Room> rooms;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @OneToMany(mappedBy = "building")
    private List<Chair> chairList;

    public Building(){
    }

    // Parameterized constructor
    public Building(String name, List<Room> rooms, University university, List<Chair> chairList) {
        this.name = name;
        this.rooms = rooms;
        this.university = university;
        this.chairList = chairList;
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

    // Getter and Setter for rooms
    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    // Getter and Setter for university
    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    // Getter and Setter for chairList
    public List<Chair> getChairList() {
        return chairList;
    }

    public void setChairList(List<Chair> chairList) {
        this.chairList = chairList;
    }
}
