package com.project.BookMyCinemaProject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.BookMyCinemaProject.validation.DateValidate;
import com.project.BookMyCinemaProject.validation.PhoneNoValidate;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int cid;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Pattern(regexp = "[a-zA-Z]*")
    private String customerName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Address> addresses;
    @PhoneNoValidate
    private String phoneNo;
    @DateValidate
    private LocalDate dob;

//    @JsonManagedReference
    @ManyToMany(mappedBy = "customer",targetEntity = MoviesData.class,cascade = CascadeType.ALL)
    private List<MoviesData> watchedMovieList;





    public Customer(String email, String cname, List<Address>addresses, String phoneNo, LocalDate dob, List<MoviesData> watchedMovieList) {
        this.email = email;
        this.customerName = cname;
        this.addresses = addresses;
        this.phoneNo = phoneNo;
        this.dob = dob;
        this.watchedMovieList = watchedMovieList;
    }

    public Customer(String email, String cname, List<Address>addresses, String phoneNo, LocalDate dob) {
        this.email = email;
        this.customerName = cname;
        this.addresses = addresses;
        this.phoneNo = phoneNo;
        this.dob = dob;
    }

    public Customer() {
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Address> getAddress() {
        return addresses;
    }

    public void setAddress(List<Address>addresses) {
        this.addresses = addresses;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<MoviesData> getWatchedMovieList() {
        return watchedMovieList;
    }

    public void setWatchedMovieList(List<MoviesData> watchedMovieList) {
        this.watchedMovieList = watchedMovieList;
    }


}

