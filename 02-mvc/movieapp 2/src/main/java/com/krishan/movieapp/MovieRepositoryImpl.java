package com.krishan.movieapp;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepositoryImpl implements MovieRepository{

    private List<Movie> movies = new ArrayList<>();

    MovieRepositoryImpl(){
        movies.add(new Movie("Jab We Met", "Romance", 2007));
        movies.add(new Movie("Saiyaara", "Romance", 2025));
        movies.add(new Movie("Sanam Teri Kasam", "Romance", 2013));
        movies.add(new Movie("Dhamal", "Comedy", 2007));
        movies.add(new Movie("Dhol", "Comedy", 2009));
        movies.add(new Movie("Booksmart", "Comedy", 2019));
        movies.add(new Movie("The Godfather", "Drama", 1972));
        movies.add(new Movie("Forrest Gump", "Drama", 1994));
        movies.add(new Movie("Parasite", "Drama", 2019));
    }

    @Override
    public List<Movie> findByGenre(String genre) {
        List<Movie> moviesByGenre = new ArrayList<>();
        for(Movie movie : movies){
            if(movie.getGenre().equalsIgnoreCase(genre)){
                moviesByGenre.add(movie);
            }
        }
        return moviesByGenre;
    }

    @Override
    public List<String> findAllGenres() {
        //Using a set to return unique movies
        Set<String> uniqueGenres = new HashSet<>();
        for(Movie movie : movies){
            uniqueGenres.add(movie.getGenre());
        }
        List<String> genres = new ArrayList<>(uniqueGenres);
        Collections.sort(genres);
        return genres;
    }
}
