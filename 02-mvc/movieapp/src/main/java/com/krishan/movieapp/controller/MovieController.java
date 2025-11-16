package com.krishan.movieapp.controller;

import com.krishan.movieapp.dao.MovieRepository;
import com.krishan.movieapp.model.User;
import com.krishan.movieapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/welcome")
    public String welcomePage() {
        return "welcome";
    }

    @RequestMapping("/signup")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }

    @RequestMapping("/register")
    public String registerUser(@ModelAttribute("user") User user){
        int userId = movieService.registerUser(user);
        String userName = user.getUserName();
        if(userId != -1){
            ModelAndView mv = new ModelAndView("redirect:success?id="+userId+"&userName=" + userName);
            return mv.getViewName();
        }
        return "signup";
    }

    @RequestMapping("/success")
    public String successPage(@RequestParam("id") String userId, @RequestParam("userName") String userName, Model model){
        model.addAttribute("userId", userId);
        model.addAttribute("userName", userName);
        return "success";
    }

    @RequestMapping("/genre")
    public String genreSelection(@RequestParam("id") String userId, @RequestParam("name") String userName, Model model){
        List<String> genres = movieService.getAllGenre();
        model.addAttribute("genres", genres);
        model.addAttribute("userId", userId);
        model.addAttribute("userName", userName);

        return "genre";
    }

    @RequestMapping("/recommend")
    public String recommendationPage(
            @RequestParam("genre") String selectedGenre,
            @RequestParam("id") String userId,
            @RequestParam("name") String userName,
            Model model
    ){

        List<String> recommendations = movieService.getRecommendationByGenre(selectedGenre);

        model.addAttribute("recommendations", recommendations);
        model.addAttribute("selectedGenre", selectedGenre);
        model.addAttribute("userName", userName);
        model.addAttribute("userId", userId);

        return "recommendations";

    }





}
