package com.bsb.ejercicio.controller;

import com.bsb.ejercicio.model.entity.Movie;
import com.bsb.ejercicio.service.MovieCollections;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    @GetMapping("/movie/{title}")
    public List<Movie> getMovieTitle(@PathVariable String title) {
        return MovieCollections.findTitle(title);
    }

    @GetMapping("/movie")
    public List<Movie> getMovieAll() {
        return MovieCollections.getAll();
    }

    @GetMapping("/movie/gender/{gender}")
    public List<Movie> getMovieGender( @PathVariable String gender)
    {
        return MovieCollections.findByGender(gender);
    }
}
