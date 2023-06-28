package com.project.BookMyCinemaProject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
public class MoviesData {
    @Id
    private int id;
    @NotNull
    private String theatreName;
    @NotNull
    private String location;
    @NotNull
    @Size(min = 2)
    private String movieName;

    @NotNull
    private LocalDate date;

    @NotNull
    @Pattern(regexp = "[0-9]*")
    private String price;

//@JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Customer> customer;



    public MoviesData() {
    }

    public MoviesData(String tname, String location, String mname, LocalDate date, String price) {
        this.theatreName = tname;
        this.location = location;
        this.movieName = mname;
        this.date = date;
        this.price = price;
    }

    public MoviesData(int id, String tname, String location, String mname, LocalDate date, String price, List<Customer> customer) {
        this.id = id;
        this.theatreName = tname;
        this.location = location;
        this.movieName = mname;
        this.date = date;
        this.price = price;
        this.customer = customer;
    }

    public MoviesData(String tname, String location, String mname, LocalDate date, String price, List<Customer> customer) {
        this.theatreName= tname;
        this.location = location;
        this.movieName = mname;
        this.date = date;
        this.price = price;
        this.customer = customer;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
