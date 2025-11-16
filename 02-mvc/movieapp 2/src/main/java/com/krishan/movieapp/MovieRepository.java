package com.krishan.movieapp;

import java.util.List;

public interface MovieRepository {
    public List<Movie> findByGenre(String genre);
    public List<String> findAllGenres();
}
