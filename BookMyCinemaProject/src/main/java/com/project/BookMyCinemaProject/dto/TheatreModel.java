package com.project.BookMyCinemaProject.dto;

import com.project.BookMyCinemaProject.validation.LocationValidate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class TheatreModel {
    @NotNull
    @Size(min = 4)
    private String theatreName;

    @NotNull
    private String screens;

    @LocationValidate
    private String location;

    List<MovieModels> movieModelList;

    public TheatreModel(String theatreName, String screens, String location, List<MovieModels> movieModelList) {
        this.theatreName = theatreName;
        this.screens = screens;
        this.location = location;
        this.movieModelList = movieModelList;
    }

    public TheatreModel(String theatreName, String screens, String location) {
        this.theatreName = theatreName;
        this.screens = screens;
        this.location = location;
    }

    public TheatreModel() {
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

    public List<MovieModels> getMovieModelList() {
        return movieModelList;
    }

    public void setMovieModelList(List<MovieModels> movieModelList) {
        this.movieModelList = movieModelList;
    }
}
