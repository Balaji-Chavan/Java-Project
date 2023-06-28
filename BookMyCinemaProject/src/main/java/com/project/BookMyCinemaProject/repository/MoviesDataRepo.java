package com.project.BookMyCinemaProject.repository;

import com.project.BookMyCinemaProject.entity.MoviesData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesDataRepo extends JpaRepository<MoviesData,Integer> {
}
