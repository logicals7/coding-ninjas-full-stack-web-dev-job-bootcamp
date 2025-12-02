package com.example.MovieTicket.MovieBooking.Model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    @Size(min=1)
    String id;
    @Size(min=3, max = 20)
    String movieName;
    @NotNull
    String movieDirector;
    @Min(value = 1) @Max(value = 10)
    long movieRating;
    String movieLanguage;
    List<String> writers;
    List<String> actors;
    List<String> genre;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public long getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(long movieRating) {
        this.movieRating = movieRating;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", movieName='" + movieName + '\'' +
                ", movieDirector='" + movieDirector + '\'' +
                ", movieRating=" + movieRating +
                ", movieLanguage='" + movieLanguage + '\'' +
                ", writers=" + writers +
                ", actors=" + actors +
                ", genre=" + genre +
                '}';
    }
}
