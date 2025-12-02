package com.example.MovieTicket.MovieBooking.service;

import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExists;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.communicator.RatingRestCommunicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieService implements MovieServiceInterface{

    @Autowired
    private RatingRestCommunicator ratingRestCommunicator;

    List<Movie> movies = new ArrayList<>();
    Map<String, Movie> movieMap = new HashMap<>();

    @Override
    public List<Movie> getAllMovies(){
        return movies;
    }

    @Override
    public Movie getMovie(String id) {
        if(ObjectUtils.isEmpty(movieMap.get(id))){
            throw new IdNotFound("Movie not found for id: " + id);
        }
        Movie movie = movieMap.get(id);

        //sets rating from rating service in response
        long rating = ratingRestCommunicator.getRating(id);
        movie.setMovieRating(rating);

        return movie;
    }

    @Override
    public void createMovie(Movie movie) {
        if(!ObjectUtils.isEmpty(movieMap.get(movie.getId()))){
            throw new IdAlreadyExists("Movie already exists for id: " + movie.getId());
        }

        //add movie in movie app
        movies.add(movie);
        movieMap.put(movie.getId(), movie);

        //add to rating app
        Map<String, Long> ratingMap = new HashMap<>();
        ratingMap.put(movie.getId(), movie.getMovieRating());

        ratingRestCommunicator.addRating(ratingMap);
    }

    @Override
    public void deleteMovie(String id) {
        if(ObjectUtils.isEmpty(movieMap.get(id))){
            throw new IdNotFound("Movie not found for id: " + id);
        }
        Movie movie = movieMap.get(id);
        movies.remove(movie);
        movieMap.remove(id);

        //delete the rating from rating app
        ratingRestCommunicator.deleteRating(id);
    }

    @Override
    public void updateMovie(Movie movie, String id) {
        if(ObjectUtils.isEmpty(movieMap.get(id))){
            throw new IdNotFound("Movie not found for id: " + id);
        }

        //update in movie app
        Movie existingmovie = movieMap.get(id);
        movies.remove(existingmovie);
        movies.add(movie);
        movieMap.put(id, movie);

        //update in rating app
        Map<String, Long> ratingMap = new HashMap<>();
        ratingMap.put(id, movie.getMovieRating());
        ratingRestCommunicator.updateRating(ratingMap);
    }

}
