package com.krishan.movieapp.dao;

import com.krishan.movieapp.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {
    // List all the movies according to the genre(A list of movies would be saved in the repository Layer).
    private Map<String, List<String>> movieData;
    private ArrayList<Integer> userList = new ArrayList<>();

    public MovieRepository(){
        this.movieData = new HashMap<>();
        movieData.put("Action", List.of("MadMax", "Avengers"));
        movieData.put("SciFi", List.of("Martian", "Interstellar"));
        movieData.put("Horror", List.of("Conjuring", "Hit"));
    }

    public int saveUser(User user){
        int id = userList.size();
        user.setId(id);
        userList.add(id);
        System.out.println("User registered: " + user);
        return id;
    }

    public List<String> getAllGenre(){
        return new ArrayList<>(movieData.keySet());
    }

    public List<String> getMovieByGenre(String genre){
        return new ArrayList<>(movieData.getOrDefault(genre, List.of("No values found for key genre")));
    }

}
