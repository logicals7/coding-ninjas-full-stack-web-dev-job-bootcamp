package com.example.MovieTicket.MovieBooking.service;

import com.example.MovieTicket.MovieBooking.Model.Movie;

import java.util.List;

public interface MovieServiceInterface {
    public List<Movie> getAllMovies();
    public Movie getMovie(String id);
    public void createMovie(Movie movie);
    public void deleteMovie(String id);
    void updateMovie(Movie topic, String id);
}
