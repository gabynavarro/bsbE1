package com.bsb.ejercicio.model.mapper;

import com.bsb.ejercicio.model.dto.MovieResponse;
import com.bsb.ejercicio.model.entity.Movie;

public class MovieMapper {
    public static MovieResponse createMovieResponse(Movie m) {
        MovieResponse response = new MovieResponse();
        response.setTitle(m.getTitle());
        response.setDate(m.getDate());
        response.setScore(m.getScore());
        return response;
    }
}
