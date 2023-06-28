package com.project.BookMyCinemaProject.service;

import com.project.BookMyCinemaProject.dto.MovieModel;
import com.project.BookMyCinemaProject.dto.MovieModels;
import com.project.BookMyCinemaProject.dto.TheatreModel;
import com.project.BookMyCinemaProject.entity.Movies;
import com.project.BookMyCinemaProject.entity.Theatre;
import com.project.BookMyCinemaProject.repository.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TheatreService {
    @Autowired
    TheatreRepo theatreRepo;

    public String addTheatre(Theatre theatre){
        List<Theatre> theatreList = theatreRepo.findAll();
        List list =new ArrayList<>() ;
        if(theatreList.size()>0){
            theatreList.forEach(theatre1  -> {
                if(theatre1.getLocation().equalsIgnoreCase(theatre.getLocation()) &&
                        theatre1.getTheatreName().equalsIgnoreCase(theatre.getTheatreName()) ){
                    list.add(1);
                }
            });
        }

        if(list.size()>0)
        return "Theatre already Present!!";
        long a = theatreRepo.count();
        theatreRepo.save(theatre);
        long b = theatreRepo.count();
        if(b>a)
        return "Theatre Added Successfully!!";
        return "Theatre Not Added";
    }



    public String addMovies(String tid, Movies movies){
        Optional<Theatre> t = theatreRepo.findById(tid);
        if(t.isPresent()){
            Theatre theatre = t.get();

            if(LocalDate.now().compareTo(movies.getDate())>0)
                return "please check movies date!!";

            int a = theatre.getListOfTheatreMovies().size();
            theatre.getListOfTheatreMovies().add(movies);
            theatreRepo.save(theatre);
            if(a<theatre.getListOfTheatreMovies().size())
            return "movies added successfully!!";

            return "movies not added!!";
        }
        return "please write correct Theatre id";
    }

    public List<TheatreModel> getTheatreBasedOnLocation(String location){
        List<Theatre> theatreList = theatreRepo.findAll();
        List<TheatreModel> theatreModelsList = new ArrayList<>();
        if(theatreList.size()>0){
            theatreModelsList =  theatreList
                    .stream()
                    .filter(theatre ->  theatre.getLocation().equalsIgnoreCase(location))
                    .map(theatre ->{
                        TheatreModel theatreModel= new TheatreModel(theatre.getTheatreName(),
                                                                     theatre.getScreens(),
                                                                     theatre.getLocation());
                        List<MovieModels> movieModelsList = new ArrayList<>();
                        theatre.getListOfTheatreMovies()
                                .forEach(movie ->{
                            MovieModels movieModels =new MovieModels(movie.getMovieName(),
                                                                   movie.getPrice(),
                                                                   movie.getTotalTicket(),
                                                                   movie.getAvailableTicket(),
                                                                   movie.getDate());
                            movieModelsList.add(movieModels);
                        });
                        theatreModel.setMovieModelList(movieModelsList);
                        return  theatreModel;
                    })
                    .collect(Collectors.toList());

            if(theatreModelsList.size()>0){
                return  theatreModelsList;
            }
            return null;
        }
        return null;
    }



    public List<MovieModel> getAllMoviesBasedOnLocationPriceName(String location,String price,String name){
        List<Theatre> theatreList = theatreRepo.findAll();
        List<MovieModel> movieModelList = new ArrayList<>();
        if(theatreList.size()>0){
            theatreList
                    .stream()
                    .filter(theatre -> theatre.getLocation().equalsIgnoreCase(location))
                    .forEach(theatre -> {
                        theatre.getListOfTheatreMovies()
                                .forEach(movie ->{
                                    if(movie.getMovieName().equalsIgnoreCase(name) &&
                                            movie.getPrice().equalsIgnoreCase(price)){
                                        MovieModel movieModel= new MovieModel(theatre.getTheatreName(),
                                                                               movie.getMovieName(),
                                                                               movie.getPrice(),
                                                                               movie.getTotalTicket(),
                                                                               movie.getAvailableTicket(),
                                                                               movie.getDate());
                                        movieModelList.add(movieModel);
                                    }
                                });
                    });
            return movieModelList;
        }
        return null;
    }
}

