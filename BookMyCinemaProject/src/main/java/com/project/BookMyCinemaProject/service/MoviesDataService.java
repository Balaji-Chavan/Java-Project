package com.project.BookMyCinemaProject.service;

import com.project.BookMyCinemaProject.dto.MoviesModel;
import com.project.BookMyCinemaProject.entity.Customer;
import com.project.BookMyCinemaProject.entity.MoviesData;
import com.project.BookMyCinemaProject.entity.Theatre;
import com.project.BookMyCinemaProject.repository.CustomerRepo;
import com.project.BookMyCinemaProject.repository.MoviesDataRepo;
import com.project.BookMyCinemaProject.repository.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MoviesDataService {
    @Autowired
    MoviesDataRepo moviesDataRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
   TheatreRepo theatreRepo;



    public List<MoviesModel> getAllWatchedMoviesById(int id) {

        Optional<Customer> customerOptional = customerRepo.findById(id);

        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            List<MoviesData> moviesDataList = customer.getWatchedMovieList();

            List<MoviesModel> moviesModelList = new ArrayList<>();
            if (moviesDataList.size() > 0) {
                moviesModelList = moviesDataList
                        .stream()
                        .filter(movie -> (LocalDate.now().compareTo(movie.getDate()))>=0)
                        .map(movie -> {
                            MoviesModel mm = new MoviesModel(movie.getTheatreName(), movie.getLocation(), movie.getMovieName(), movie.getDate(), movie.getPrice());
                            return mm;
                        }).collect(Collectors.toList());

                return moviesModelList;
            }

            return null;
        }
        return null;
    }



    public List<MoviesModel> getAllWatchedAndBookedMoviesByIdAndDate(int id, LocalDate date){
        Optional<Customer> customerOptional = customerRepo.findById(id);

        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            List<MoviesData> moviesDataList = customer.getWatchedMovieList();

            List<MoviesModel> moviesModelList = new ArrayList<>();
            if (moviesDataList.size() > 0) {
                moviesDataList= moviesDataList
                               .stream()
                               .filter(movie -> movie.getDate().isEqual(date))
                               .collect(Collectors.toList());
                if (moviesDataList.size() > 0) {
                    moviesModelList = moviesDataList
                                     .stream()
                                     .map(movie -> {
                                 MoviesModel mm = new MoviesModel(movie.getTheatreName(),
                                                                 movie.getLocation(),
                                                                 movie.getMovieName(),
                                                                 movie.getDate(),
                                                                 movie.getPrice());
                                return mm;
                            }).collect(Collectors.toList());
                   }
            }
            return moviesModelList;
        }
        return null;
    }


    public ResponseEntity<List<MoviesModel>> getAvilableMovieByDate(LocalDate date){
        List<MoviesModel> moviesModelList = new ArrayList<>();

        if(LocalDate.now().compareTo(date)>0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();


        List<Theatre> theatreList = theatreRepo.findAll();

        if(theatreList.size()>0){
            theatreList
            .forEach(theatre -> {
              List<MoviesModel> moviesModelList1=  theatre.getListOfTheatreMovies()
                        .stream()
                        .filter(movies -> movies.getDate().isEqual(date) &&
                                           Integer.valueOf(movies.getAvailableTicket())>0)
                        .map(movies -> {
                            MoviesModel m = new MoviesModel(theatre.getTheatreName(),
                                                            theatre.getLocation(),
                                                            movies.getMovieName(),
                                                            movies.getDate(),
                                                            movies.getPrice());
                            return m;
                        }).collect(Collectors.toList());

              moviesModelList.addAll(moviesModelList1);

            });
        }

        return ResponseEntity.ok(moviesModelList);
    }
}
