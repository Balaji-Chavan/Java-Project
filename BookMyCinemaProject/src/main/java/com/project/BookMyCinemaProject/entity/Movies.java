package com.project.BookMyCinemaProject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Movies {
    @Id
    @GeneratedValue
    private int mid;
    @NotNull
    @Size(min = 2)
    private String movieName;

    @NotNull
    @Pattern(regexp = "[0-9]*")
    private String price;
    @NotNull
    @Pattern(regexp = "[0-9]*")
    private String totalTicket;
    @NotNull
    @Pattern(regexp = "[0-9]*")
    private String availableTicket;

    @NotNull
    private LocalDate date;


    public Movies(String movieName, String price, String totalTicket, String availableTicket, LocalDate date) {
        this.movieName = movieName;
        this.price = price;
        this.totalTicket = totalTicket;
        this.availableTicket = availableTicket;
        this.date = date;
    }

    public Movies() {
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotalTicket() {
        return totalTicket;
    }

    public void setTotalTicket(String totalTicket) {
        this.totalTicket = totalTicket;
    }

    public String getAvailableTicket() {
        return availableTicket;
    }

    public void setAvailableTicket(String availableTicket) {
        this.availableTicket = availableTicket;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
