package com.project.BookMyCinemaProject.dto;

import com.project.BookMyCinemaProject.entity.Address;
import com.project.BookMyCinemaProject.validation.DateValidate;
import com.project.BookMyCinemaProject.validation.PhoneNoValidate;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class CustomerModel {
    private int cid;
    @NotNull
    private String email;
    @NotNull
    private String cname;
    @NotNull
    private List<Address> addresses;
    @PhoneNoValidate
    private String phoneNo;
    @DateValidate
    private LocalDate dob;

    public CustomerModel(int cid, String email, String cname, List<Address> addresses, String phoneNo, LocalDate dob) {
        this.cid = cid;
        this.email = email;
        this.cname = cname;
        this.addresses = addresses;
        this.phoneNo = phoneNo;
        this.dob = dob;
    }

    public CustomerModel() {
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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Address>  getAddress() {
        return addresses;
    }

    public void setAddress(List<Address> addresses) {
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
}
