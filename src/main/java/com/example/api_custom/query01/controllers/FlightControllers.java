package com.example.api_custom.query01.controllers;

import com.example.api_custom.query01.entities.Flight;
import com.example.api_custom.query01.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")

public class FlightControllers {
    @Autowired
    private FlightService flightService;

    @PostMapping("/add")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
        return ResponseEntity.ok().body(flightService.addFlight(flight));
    }
    @GetMapping("/list")
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightService.generateFlights();
        return ResponseEntity.ok().body(flights);
    }
    @GetMapping("/getFlight/{id}")
    public ResponseEntity<Optional<Flight>> getFlightId(@PathVariable Long id){
        Optional<Flight> flightOptional = flightService.findById(id);
        return ResponseEntity.ok().body(flightOptional);
    }
    @PutMapping("/updateFlight/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id,@RequestBody Flight flight){
        Optional<Flight> flightOptional = flightService.updateFlight(flight,id);
        if(flightOptional.isPresent()){
            return ResponseEntity.ok().body(flight);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/deleteFlight/{id}")
    public ResponseEntity<Flight> deleteFlight(@PathVariable Long id){
        Optional<Flight> delete = flightService.deleteFlight(id);
        return ResponseEntity.ok().body(delete.get());
    }

    @GetMapping("/findByDescrizione")
    public List<Flight> findByDescription(@RequestParam String descrizione){
        return flightService.findByDescription(descrizione);
    }
    @GetMapping("/findByToAirport")
    public List<Flight> findByToAirport(@RequestParam String toAirport){
        return flightService.findByDescription(toAirport);
    }
    @GetMapping("/findBy")
    public List<Flight> findByEnum(@RequestParam Enum statusEnum){
        return flightService.findByDescription(String.valueOf(statusEnum));
    }
    @GetMapping("/findBy")
    public List<Flight> findByFromAirport(@RequestParam String fromAirport){
        return flightService.findByDescription(fromAirport);
    }




}
