package com.project.BookMyCinemaProject.dto;

import java.time.LocalDate;

public class MoviesModel {
    private String tname;

    private String location;

    private String mname;


    private LocalDate date;


    private String price;

    public MoviesModel(String tname, String location, String mname, LocalDate date, String price) {
        this.tname = tname;
        this.location = location;
        this.mname = mname;
        this.date = date;
        this.price = price;
    }

    public MoviesModel() {
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
