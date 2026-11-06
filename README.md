# Flight Booking Application — Flight Service
Self-study project, Jan–Feb 2025. A Spring Boot microservice for flight details, part of a full-stack flight booking app like MakeMyTrip.

## What this service does
- REST API for flights at `/flights` (see below).
- It does not use a database directly. It calls the DataStore service with RestTemplate at `http://localhost:8081/flights`.
- Runs on port 8083. The DataStore service must be running on port 8081 first.

## API endpoints
- GET /flights — get all flights
- GET /flights/{id} — get one flight by id
- POST /flights — add a flight
- PUT /flights/{id} — update a flight
- DELETE /flights/{id} — delete a flight

## Flight details (FlightDTO)
id, flightNumber, departure, arrival, departureTime, arrivalTime, price, availableSeats.

## Tech used
Java 17, Spring Boot 3.4.1, Spring Data JPA, REST APIs, Gradle, Docker, Log4j2 logging, OpenAPI/Swagger (see /swagger-ui).

## How to run
./gradlew bootRun — then the service runs on port 8083.

## Related repos
TafBookingService, TafUserService, TafDataStoreService, and app (Angular front end).
