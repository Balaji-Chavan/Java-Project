package com.project.BookMyCinemaProject.repository;

import com.project.BookMyCinemaProject.dto.MoviesModel;
import com.project.BookMyCinemaProject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {

@Query("SELECT new com.project.BookMyCinemaProject.dto.MoviesModel(m.theatreName,m.location,m.movieName,m.date,m.price)from Customer c join c.watchedMovieList m where c.cid=?1 AND m.date=?2")
    public List<MoviesModel> getAllMoviesData(int id, LocalDate date);

@Query("SELECT new com.project.BookMyCinemaProject.dto.MoviesModel(m.theatreName,m.location,m.movieName,m.date,m.price)from Customer c join c.watchedMovieList m where c.cid=?1 AND m.date<=CURRENT_DATE")
public List<MoviesModel> getAllWatchedMovie(int id);



}
