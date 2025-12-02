package com.example.MovieTicket.MovieBooking.controller;

import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class Controller {

    @Autowired
    public MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @PostMapping("/movie")
    public void createMovie(@Valid @RequestBody Movie movie, BindingResult bindingResult){
        if(bindingResult.hasErrors()) throw new RuntimeException("Request not valid for movie creation!!");
        movieService.createMovie(movie);
    }

    @GetMapping("/movie/{id}")
    public Movie getMovie(@PathVariable String id){
        return movieService.getMovie(id);
    }

    @DeleteMapping("/movie/{id}")
    public void deleteMovie(@PathVariable String id){
        movieService.deleteMovie(id);
    }

    @PutMapping("/update/{id}")
    public void updateMovie(@RequestBody Movie topic, @PathVariable String id){
        movieService.updateMovie(topic, id);
    }

}
