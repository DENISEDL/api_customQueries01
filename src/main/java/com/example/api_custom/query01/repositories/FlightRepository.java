package com.example.api_custom.query01.repositories;

import com.example.api_custom.query01.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    List<Flight> findByDescription(String description);
    List<Flight> findByFromAirport(String fromAirport);
    List<Flight> findByToAirport(String toAirport);
    List<Flight> findByEnum(Enum statusEnum);

}
