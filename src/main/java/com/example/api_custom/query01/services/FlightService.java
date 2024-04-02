package com.example.api_custom.query01.services;

import com.example.api_custom.query01.entities.Flight;
import com.example.api_custom.query01.enums.StatusEnum;
import com.example.api_custom.query01.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    /**
     * Generiamo 50 voli in random con enumStatus"ONETIME"
     * salviamo i voli nel database
     * @return la lista di voli
     */
    public List<Flight> generateFlights() {
        List<Flight> flights = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            Flight flight = new Flight();
            flight.setDescription("Flight " + random.nextInt(1000));
            flight.setFromAirport("Airport " + random.nextInt(100));
            flight.setToAirport("Airport " + random.nextInt(100));
            flight.setStatusEnum(StatusEnum.ONTIME);
            flights.add(flight);
            flightRepository.saveAndFlush(flight);
        }
        return flights;
    }
}
