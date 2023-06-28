package com.project.BookMyCinemaProject.service;

import com.project.BookMyCinemaProject.entity.*;
import com.project.BookMyCinemaProject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    TicketRepo ticketRepo;

    @Autowired
    MoviesDataRepo moviesDataRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    TheatreRepo theatreRepo;

    @Autowired
    MoviesRepo moviesRepo;

    public String bookTicket(int cid , Ticket ticket){
        Optional<Customer> customerOptional =customerRepo.findById(cid);
        Customer customer= customerOptional.get();
        if(!customerOptional.isPresent()){
            return "Customer Id is not Correct!!";
        }
        ticket.setCustomer(customer);


//        LocalDate todayDate = LocalDate.now();
//        if(ticket.getDate().getYear()<todayDate.getYear() ||
//            (ticket.getDate().getYear()==todayDate.getYear() &&
//             ticket.getDate().getDayOfYear()<todayDate.getDayOfYear()) ){
//
//            return "Check ticket date it is not correct!!";
//        }


        List<Theatre> theatreList = theatreRepo.findAll();
        List<Movies> moviesList =new ArrayList<>();

        if(theatreList.size()>0){
            theatreList.stream()
                    .filter(theatre -> theatre.getLocation().equalsIgnoreCase(ticket.getLocation() )&&
                                       theatre.getTheatreName().equalsIgnoreCase(ticket.getTheatreName()))
                    .forEach(theatre -> {
                        theatre.getListOfTheatreMovies()
                                .stream()
                                .filter(movies -> movies.getMovieName().equalsIgnoreCase(ticket.getMovieName())&&
                                        movies.getDate().isEqual(ticket.getDate()))
                                .forEach(movie ->{
                                    if(Integer.valueOf(movie.getAvailableTicket())>0){
                                        int a = Integer.valueOf(movie.getAvailableTicket()) -1;
                                        movie.setAvailableTicket(Integer.toString(a));
                                        moviesList.add(movie);
                                    }
                                });
                    });
        }
        if(moviesList.size()>0){
            Movies movie =moviesList.get(0);
            moviesRepo.save(movie);
            Optional<MoviesData> optionalMoviesData = moviesDataRepo.findById(movie.getMid());
            if(optionalMoviesData.isPresent()){
                MoviesData moviesData = optionalMoviesData.get();
                moviesData.getCustomer().add(customer);
                moviesDataRepo.save(moviesData);
            }
            else{
                MoviesData moviesData = new MoviesData(ticket.getTheatreName(),ticket.getLocation(),ticket.getMovieName(),movie.getDate(),movie.getPrice());
                moviesData.setId(movie.getMid());
                List<Customer> customerList = new ArrayList<>();
                customerList.add(customer);
                moviesData.setCustomer(customerList);
                moviesDataRepo.save(moviesData);


            }
            ticketRepo.save(ticket);
            return "Ticket Booked Successfully!!";
        }
        return "Ticket is not available";
    }
}