package com.project.BookMyCinemaProject.controller;

import com.project.BookMyCinemaProject.dto.MoviesModel;
import com.project.BookMyCinemaProject.service.MoviesDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/moviedata")
public class MoviesDataController {
    @Autowired
    MoviesDataService moviesDataService;

    @GetMapping("/watched-movie-byid/{id}")
    public List<MoviesModel> getAllWatchedMovie(@PathVariable int id){
        return moviesDataService.getAllWatchedMoviesById(id);
    }

    @GetMapping("/watched-movie-by-id-date/{id}/{date}")
    public List<MoviesModel> getAllWatchedMovieByIDAndDate(@PathVariable int id, @PathVariable String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);
        return moviesDataService.getAllWatchedAndBookedMoviesByIdAndDate(id,localDate);
    }


    @GetMapping("/movie-available-by-date/{date}")
    public ResponseEntity<List<MoviesModel>> getAllAvailableMovieByDate(@PathVariable String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);
        return moviesDataService.getAvilableMovieByDate(localDate);
    }
}
