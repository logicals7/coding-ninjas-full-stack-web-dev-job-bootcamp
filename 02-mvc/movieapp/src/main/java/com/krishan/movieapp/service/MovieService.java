package com.krishan.movieapp.service;

import com.krishan.movieapp.dao.MovieRepository;
import com.krishan.movieapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public int registerUser(User user){
        if(user.getUserName() == null || user.getEmail() == null || user.getPassword() == null){
            return -1;
        }
        return movieRepository.saveUser(user);
    }

    public List<String> getAllGenre(){
        return movieRepository.getAllGenre();
    }

    public List<String> getRecommendationByGenre(String genre){
        return movieRepository.getMovieByGenre(genre);
    }


}
