package com.project.BookMyCinemaProject.repository;

import com.project.BookMyCinemaProject.dto.MovieModel;
import com.project.BookMyCinemaProject.dto.MoviesModel;
import com.project.BookMyCinemaProject.entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre,String> {


    @Query("select new com.project.BookMyCinemaProject.dto.MovieModel(t.theatreName,m.movieName,m.price,m.totalTicket,m.availableTicket,m.date) from Theatre t join t.listOfTheatreMovies m where t.location=?1 AND m.price=?2 AND m.movieName=?3")
    public List<MovieModel> getAllMoviesBasedOnLocationPriceName(String location,String price, String movieName);

    @Query("SELECT new com.project.BookMyCinemaProject.dto.MoviesModel(t.theatreName,t.location,m.movieName,m.date,m.price)from Theatre t join t.listOfTheatreMovies m where m.date=?1 AND CURRENT_DATE<=?1 AND m.availableTicket>0")
    public List<MoviesModel> getAllAvailableMovie(LocalDate date);


}
