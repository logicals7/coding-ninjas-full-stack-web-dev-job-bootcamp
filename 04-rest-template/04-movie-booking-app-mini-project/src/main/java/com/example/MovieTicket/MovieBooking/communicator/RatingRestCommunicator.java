package com.example.MovieTicket.MovieBooking.communicator;

import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExists;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class RatingRestCommunicator {

    private final RestTemplate restTemplate;

    @Autowired
    public RatingRestCommunicator(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    String baseUrl = "http://localhost:8081/rating/";

    public long getRating(String id){
        String url = baseUrl + "/id/" + id;
        try{
            ResponseEntity<Long> response = restTemplate.exchange(url, HttpMethod.GET, null, Long.class);
            return response.getBody() != null ? response.getBody() : 0L;
        } catch(HttpClientErrorException.NotFound e) {
            throw new IdNotFound("Rating not exists with id: " + id);
        } catch (RestClientException ex) {
            throw new RuntimeException("Failed to fetch rating for id: " + id);
        }
    }

    public void addRating(Map< String,Long > ratingsMap){
        String url = baseUrl + "/add";
        HttpEntity<Map<String, Long>> request = new HttpEntity<>(ratingsMap);
        try{
            restTemplate.exchange(url, HttpMethod.POST, request, Object.class);
        } catch(HttpClientErrorException.NotFound e){
            throw new IdAlreadyExists("Rating already exists: " + ratingsMap);
        } catch (RestClientException ex) {
            throw new RuntimeException("Failed to add rating: " + ratingsMap);
        }
    }

    public void updateRating(Map<String, Long> ratingsMap) {
        String url = baseUrl + "/update";
        HttpEntity<Map<String, Long>> request = new HttpEntity<>(ratingsMap);

        try {
            restTemplate.exchange(url, HttpMethod.PUT, request, Void.class);
        } catch (HttpClientErrorException.NotFound nf) {
            throw new IdNotFound("Cannot update. Rating not found: " + ratingsMap);
        } catch (RestClientException ex) {
            throw new RuntimeException("Failed to update rating: " + ratingsMap);
        }
    }

    public void deleteRating(String id) {
        String url = baseUrl + "/id/" + id;
        try {
            restTemplate.exchange(url, HttpMethod.DELETE, null, Void.class);
        } catch (HttpClientErrorException.NotFound nf) {
            throw new IdNotFound("Cannot delete. Rating not found for id: " + id);
        } catch (RestClientException ex) {
            throw new RuntimeException("Failed to delete rating for id: " + id);
        }
    }
}
