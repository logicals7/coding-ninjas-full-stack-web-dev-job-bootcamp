package com.example.MovieTicket.MovieBooking.service;

import com.example.MovieTicket.MovieBooking.Model.Movie;

import java.util.List;

public interface MovieServiceInterface {
    public List<Movie> getAllMovies();
    public Movie getMovieById(String id);
    public void createMovie(Movie movie);
    public void deleteMovieById(String id);
    void updateMovieById(Movie topic, String id);
}
