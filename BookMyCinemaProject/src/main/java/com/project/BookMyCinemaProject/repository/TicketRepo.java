package com.project.BookMyCinemaProject.repository;

import com.project.BookMyCinemaProject.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<Ticket,Integer> {
}
