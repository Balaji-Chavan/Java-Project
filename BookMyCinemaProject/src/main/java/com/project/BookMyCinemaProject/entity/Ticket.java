package com.project.BookMyCinemaProject.entity;

import javax.persistence.*;
import java.time.LocalDate;


    @Entity
    public class Ticket {
        @Id
        @GeneratedValue
        private int ticketId;

        private String theatreName;
        private String movieName;

        private LocalDate date;

        private String location;
        @ManyToOne()
        @JoinColumn(name = "customer_id_fk")
        private Customer customers;


        public Ticket(String theatreName, String movieName, LocalDate date, String location, Customer customers) {
            this.theatreName = theatreName;
            this.movieName = movieName;
            this.date = date;
            this.location = location;
            this.customers = customers;
        }

        public Ticket(String theatreName, String movieName, LocalDate date, String location) {
            this.theatreName = theatreName;
            this.movieName = movieName;
            this.date = date;
            this.location = location;
        }

        public Ticket() {
        }

        public int getId() {
            return ticketId;
        }

        public void setId(int ticketId) {
            this.ticketId = ticketId;
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

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public Customer getCustomer() {
            return customers;
        }

        public void setCustomer(Customer customer) {
            this.customers = customer;
        }
    }

