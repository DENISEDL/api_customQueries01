package com.example.api_custom.query01.repositories;

import com.example.api_custom.query01.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
}
