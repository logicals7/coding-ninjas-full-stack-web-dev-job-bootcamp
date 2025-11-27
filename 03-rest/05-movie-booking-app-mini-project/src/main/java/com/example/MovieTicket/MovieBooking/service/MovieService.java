package com.example.MovieTicket.MovieBooking.service;

import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFoundException;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService implements MovieServiceInterface{

    List<Movie> movies = new ArrayList<>();
    Map<String, Movie> movieMap = new HashMap<>();

    public List<Movie> getAllMovies(){
        return movies;
    }

    @Override
    public Movie getMovieById(String id) {
        if(ObjectUtils.isEmpty(movieMap.get(id))){
            throw new IdNotFoundException("Movie not found for id: " + id);
        }
        Movie movie = movieMap.get(id);
        return movie;
    }

    @Override
    public void createMovie(Movie movie) {
        if(!ObjectUtils.isEmpty(movieMap.get(movie.getId()))){
            throw new IdNotFoundException("Movie already exists for id: " + movie.getId());
        }
        movies.add(movie);
        movieMap.put(movie.getId(), movie);
    }

    @Override
    public void deleteMovieById(String id) {
        if(ObjectUtils.isEmpty(movieMap.get(id))){
            throw new IdNotFoundException("Movie not found for id: " + id);
        }
        Movie movie = movieMap.get(id);
        movies.remove(movie);
        movieMap.remove(id);
    }

    @Override
    public void updateMovieById(Movie topic, String id) {
        if(ObjectUtils.isEmpty(movieMap.get(id))){
            throw new IdNotFoundException("Movie not found for id: " + id);
        }
        Movie existingmovie = movieMap.get(id);
        movies.remove(existingmovie);
        movies.add(topic);
        movieMap.put(id, topic);
    }

}
