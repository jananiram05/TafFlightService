package com.tekarch.TafFlightService.controller;
import com.tekarch.TafFlightService.dto.FlightDTO;
import com.tekarch.TafFlightService.service.FlightServiceImpl;
import com.tekarch.TafFlightService.service.Interfaces.FlightService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500") // Frontend origin
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;
    private static final Logger logger= LogManager.getLogger(FlightController.class);


    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public ResponseEntity<List<FlightDTO>> getAllFlights() {
        logger.info("Fetching all flights");
        return ResponseEntity.ok(flightService.getAllFlights());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDTO> getFlightById(@PathVariable Long id) {
        return ResponseEntity.ok(flightService.getFlightById(id));
    }

    @PostMapping
    public ResponseEntity<FlightDTO> addFlight(@RequestBody FlightDTO flightDTO) {
        logger.info("Creating all flights");
        return ResponseEntity.ok(flightService.addFlight(flightDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFlight(@PathVariable Long id, @RequestBody FlightDTO flightDTO) {
        flightService.updateFlight(id, flightDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }
}

