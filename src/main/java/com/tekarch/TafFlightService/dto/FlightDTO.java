package com.tekarch.TafFlightService.dto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightDTO {
    private Long id;
    private String flightNumber;
    private String departure;
    private String arrival;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Double price;
    private Integer availableSeats;
    private LocalDateTime createdAt=LocalDateTime.now();
    private LocalDateTime updatedAt=LocalDateTime.now();

}
