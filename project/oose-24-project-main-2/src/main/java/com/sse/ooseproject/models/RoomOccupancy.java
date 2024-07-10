package com.sse.ooseproject.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "roomOccupany")
public class RoomOccupancy {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private LocalDateTime occupancyTime;


    // Default constructor
    public RoomOccupancy() {
    }

    // Parameterized constructor
    public RoomOccupancy(Room room, Course course, LocalDateTime occupancyTime) {
        this.room = room;
        this.course = course;
        this.occupancyTime = occupancyTime;
    }

    // Getter and Setter for id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getter and Setter for room
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    // Getter and Setter for course
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    // Getter and Setter for occupancyTime
    public LocalDateTime getOccupancyTime() {
        return occupancyTime;
    }

    public void setOccupancyTime(LocalDateTime occupancyTime) {
        this.occupancyTime = occupancyTime;
    }

}
