package com.krishan.movieapp;

import java.util.List;

public interface MovieService {
    public List<Movie> getMoviesByGenre(String genre);
    public List<String> getAllGenres();
}
