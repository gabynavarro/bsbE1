package com.bsb.ejercicio.service;

import com.bsb.ejercicio.model.dto.CharacterResponse;
import com.bsb.ejercicio.model.entity.Character;
import com.bsb.ejercicio.model.entity.Movie;
import com.bsb.ejercicio.model.mapper.CharacterMapper;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

public class MovieCollections {
    private static final String ERROR_NOT_FOUND = "An error occurred in the process";

    public static List<Movie> findTitle(String title) {
        if (title == null && !Validations.validationString(title))
            throw new NullPointerException("Movie name can't be null or contains invalid characters");
        List<Movie> movies = Generator.addMovie();
        try {
            return movies.stream()
                    .filter(m -> m.getTitle().equalsIgnoreCase(title))
                    .map(MovieCollections::movieAddCharacter)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }

    }

    public static List<Movie> getAll() {
        try {
            return Generator.addMovie().stream()
                    .map(MovieCollections::movieAddCharacter)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }

    }

    /*    public static List<Movie> findByAge(String gender) {
            List<Movie> movies = Generator.addMovie();
            if (gender == null&&!Validations.validationString(gender)) {
                throw new NumberFormatException("Movie name can't be null or contains invalid characters");
            }
            return movies.stream()
                    .filter(m.gender).equalsIgnoreCase(title)
                    .map(CharacterCollections::characterAddMovie)
                    .collect(Collectors.toList());
        }*/
    public static Movie movieAddCharacter(Movie m) {
        List<Character> c = Generator.addCharacter();
        int nCharacter = (int) (Math.random() * 5 + 1);
        List<CharacterResponse> characterResponses = new ArrayList<>();
        for (int i = 0; i < nCharacter; i++) {
            characterResponses.add(CharacterMapper.createMovieResponse(c.get(i)));
            m.setCharacter(characterResponses);
        }
        return m;
    }

}
