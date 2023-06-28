package com.project.BookMyCinemaProject.repository;

import com.project.BookMyCinemaProject.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepo extends JpaRepository<Movies,Integer> {
}
