package com.tekarch.TafFlightService.service.Interfaces;

import com.tekarch.TafFlightService.dto.FlightDTO;

import java.util.List;

public interface FlightService {

    List<FlightDTO> getAllFlights();

    FlightDTO getFlightById(Long id);

    FlightDTO addFlight(FlightDTO flightDTO);

    void updateFlight(Long id, FlightDTO flightDTO);

    void deleteFlight(Long id);
}
