package com.project.BookMyCinemaProject.controller;

import com.project.BookMyCinemaProject.dto.CustomerModel;
import com.project.BookMyCinemaProject.dto.MoviesModel;
import com.project.BookMyCinemaProject.entity.Customer;
import com.project.BookMyCinemaProject.repository.CustomerRepo;
import com.project.BookMyCinemaProject.service.Customerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    Customerservice customerservice;

    @Autowired
    CustomerRepo customerRepo;

    @PostMapping("/add")
    public String add(@Valid @RequestBody Customer customer){
        return customerservice.addCustomer(customer);
    }

    @GetMapping("/get-all")
    public List<CustomerModel> getAllCustomer(){
        return  customerservice.getAllCustomer();
    }




    //By Using @Query
@GetMapping("get-watched-movie/{id}/{date}")
   public List<MoviesModel> getAllMoviesData(@PathVariable  int id ,@PathVariable String date){
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
       //convert String to LocalDate
       LocalDate localDate = LocalDate.parse(date, formatter);

       return customerRepo.getAllMoviesData(id,localDate);
   }




    //By Using @Query
   @GetMapping("get-all-watched-movie/{id}")
    public List<MoviesModel> getAllWatchedMovies(@PathVariable int id){
        return  customerRepo.getAllWatchedMovie(id);
   }


}
