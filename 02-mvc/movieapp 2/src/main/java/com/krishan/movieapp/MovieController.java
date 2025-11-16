package com.krishan.movieapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/movies") // Base mapping for all movie-related paths
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Handles requests to /movies/genre, which can come from the User registration redirect,
    // or from the genre selection form submission itself.
    @RequestMapping("/genre")
    public String showGenreSelection(
            Model model,
            // CONCEPT: @RequestParam
            // Captures optional parameters from the URL query string (e.g., ?username=...&userId=...)
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "userId", required = false) Integer userId,
            // Captures the genre selected from the dropdown form
            @RequestParam(value = "selectedGenre", required = false) String selectedGenre) {

        // 1. Prepare Model Attributes for View Personalization (from registration redirect)
        // CONCEPT: Model
        // Data is passed from Controller to View via the Model.
        model.addAttribute("username", username);
        model.addAttribute("userId", userId);

        // 2. Fetch all available genres for the dropdown
        List<String> genres = movieService.getAllGenres();
        model.addAttribute("genres", genres);

        // 3. Conditional Logic: Fetch movies if a genre has been selected
        if (selectedGenre != null && !selectedGenre.isEmpty()) {
            List<Movie> movies = movieService.getMoviesByGenre(selectedGenre);

            model.addAttribute("movies", movies);
            model.addAttribute("currentGenre", selectedGenre);
        }

        // Return the view name
        return "genre_selection"; // Maps to /WEB-INF/jsp/genre_selection.jsp
    }
}
