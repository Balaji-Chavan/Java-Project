package com.project.BookMyCinemaProject.controller;

import com.project.BookMyCinemaProject.dto.MovieModel;
import com.project.BookMyCinemaProject.dto.MoviesModel;
import com.project.BookMyCinemaProject.dto.TheatreModel;
import com.project.BookMyCinemaProject.entity.Movies;
import com.project.BookMyCinemaProject.entity.Theatre;
import com.project.BookMyCinemaProject.repository.TheatreRepo;
import com.project.BookMyCinemaProject.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
    @Autowired
    TheatreService theatreService;

    @Autowired
    TheatreRepo theatreRepo;

    @PostMapping("/add")
    public String add(@Valid  @RequestBody Theatre theatre){
        return theatreService.addTheatre(theatre);
    }

    @PostMapping("/add-movie/{id}")
    public String addMovies(@PathVariable String id ,@Valid @RequestBody Movies movies){
        return theatreService.addMovies(id,movies);
    }

    @GetMapping("/get-by-location/{location}")
    public List<TheatreModel> getThatreByLocation(@PathVariable String location){
        return theatreService.getTheatreBasedOnLocation(location);
    }

    @GetMapping("get-movie-by-location-price-name/{location}/{price}/{name}")
    public List<MovieModel> getAllMoviesBasedOnLocationPriceName(@PathVariable String location,
                                                                 @PathVariable String price,
                                                                 @PathVariable String name){
        return theatreService.getAllMoviesBasedOnLocationPriceName(location, price, name);
    }




    //By Using @Query
    @GetMapping("get-movie-by-locationpricename/{location}/{price}/{name}")
    public List<MovieModel> getAllMovieByLocationPriceName(@PathVariable String location,
                                                           @PathVariable String price,
                                                           @PathVariable String name){
        return  theatreRepo.getAllMoviesBasedOnLocationPriceName(location,price,name);
    }


    //By Using @Query
    @GetMapping("get-available-movie/{date}")
    public List<MoviesModel> getAllAvailableMovie(@PathVariable String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        LocalDate localDate =LocalDate.parse(date,formatter);

        return theatreRepo.getAllAvailableMovie(localDate);
    }
}

