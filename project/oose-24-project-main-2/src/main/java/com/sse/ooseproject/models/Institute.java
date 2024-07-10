package com.sse.ooseproject.models;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "institute")

public class Institute extends OrganizationalUnit {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String providesStudySubject;

    @OneToMany(mappedBy = "institute")
    private List<Chair> chairList;

    // Default constructor
    public Institute() {
    }

    // Parameterized constructor
    public Institute(String name, String providesStudySubject) {
        this.name = name;
        this.providesStudySubject = providesStudySubject;
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

    // Getter and Setter for providesStudySubject
    public String getProvidesStudySubject() {
        return providesStudySubject;
    }

    public void setProvidesStudySubject(String providesStudySubject) {
        this.providesStudySubject = providesStudySubject;
    }

    // Getter and Setter for chairList
    public List<Chair> getChairList() {
        return chairList;
    }

    public void setChairList(List<Chair> chairList) {
        this.chairList = chairList;
    }
}
