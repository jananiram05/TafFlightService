package com.tekarch.TafFlightService.service;



import com.tekarch.TafFlightService.dto.FlightDTO;
import com.tekarch.TafFlightService.service.Interfaces.FlightService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private final RestTemplate restTemplate;
    private static final Logger logger= LogManager.getLogger(FlightServiceImpl.class);

    @Value("${datastore.service.url}")
    private String datastoreUrl;


    public FlightServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<FlightDTO> getAllFlights() {
        logger.info("Fetching all flights from datastore at {}", datastoreUrl);

        return Arrays.asList(restTemplate.getForObject(datastoreUrl, FlightDTO[].class));
    }

    @Override
    public FlightDTO getFlightById(Long id) {
        String url = datastoreUrl + "/" + id;
        return restTemplate.getForObject(url, FlightDTO.class);
    }

    @Override
    public FlightDTO addFlight(FlightDTO flightDTO) {
        return restTemplate.postForObject(datastoreUrl, flightDTO, FlightDTO.class);
    }

    @Override
    public void updateFlight(Long id, FlightDTO flightDTO) {
        String url = datastoreUrl + "/" + id;
        logger.info("Updating flight with ID {} at {}", id, url);
        restTemplate.put(url, flightDTO);
    }

    @Override
    public void deleteFlight(Long id) {
        String url = datastoreUrl + "/" + id;
        logger.info("Deleting flight with ID {} at {}", id, url);
        restTemplate.delete(url);
    }
}

