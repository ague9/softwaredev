package com.sse.ooseproject.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "room")
public class Room {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String number;
    private long numberOfSeats;
    private boolean isAuditorium;


    @OneToMany(mappedBy = "room")
    private List<RoomOccupancy> occupancies;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    // Default constructor
    public Room() {
    }

    // Parameterized constructor
    public Room(String number, long numberOfSeats, boolean isAuditorium, Building building) {
        this.number = number;
        this.numberOfSeats = numberOfSeats;
        this.isAuditorium = isAuditorium;
        this.building = building;
    }

    // Getter and Setter for id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getter and Setter for number
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    // Getter and Setter for numberOfSeats
    public long getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(long numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    // Getter and Setter for isAuditorium
    public boolean isAuditorium() {
        return isAuditorium;
    }

    public void setAuditorium(boolean auditorium) {
        isAuditorium = auditorium;
    }

    // Getter and Setter for occupancies
    public List<RoomOccupancy> getOccupancies() {
        return occupancies;
    }

    public void setOccupancies(List<RoomOccupancy> occupancies) {
        this.occupancies = occupancies;
    }

    // Getter and Setter for building
    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
