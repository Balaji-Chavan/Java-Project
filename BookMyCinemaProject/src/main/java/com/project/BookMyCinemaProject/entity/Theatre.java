package com.project.BookMyCinemaProject.entity;

import com.project.BookMyCinemaProject.validation.LocationValidate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Theatre {
    @Id
    private String tid;
    @NotNull
    @Size(min = 4)
    private String theatreName;

    @NotNull
    private String screens;

    @LocationValidate
    private String location;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Movies> listOfTheatreMovies;

    public Theatre(String tid, String theatreName, String screens, String location) {
        this.tid = tid;
        this.theatreName = theatreName;
        this.screens = screens;
        this.location = location;
    }

    public Theatre(String tid, String theatreName, String screens, String location, List<Movies> listOfTheatreMovies) {
        this.tid=tid;
        this.theatreName = theatreName;
        this.screens = screens;
        this.location = location;
        this.listOfTheatreMovies = listOfTheatreMovies;
    }

    public Theatre() {
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getScreens() {
        return screens;
    }

    public void setScreens(String screens) {
        this.screens = screens;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Movies> getListOfTheatreMovies() {
        return listOfTheatreMovies;
    }

    public void setListOfTheatreMovies(List<Movies> listOfTheatreMovies) {
        this.listOfTheatreMovies = listOfTheatreMovies;
    }
}

