package com.bsb.ejercicio.service;

import com.bsb.ejercicio.model.dto.MovieResponse;
import com.bsb.ejercicio.model.entity.Character;
import com.bsb.ejercicio.model.entity.Movie;
import com.bsb.ejercicio.model.mapper.MovieMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CharacterCollections {
    private static final String ERROR_NOT_FOUND = "An error occurred in the process";

    public static List<Character> findName(String name) {
        try {
            if (name == null && !Validations.validationString(name))
                throw new NullPointerException("Character name can't be null or contains invalid characters");
            List<Character> characters = Generator.addCharacter();
            return characters.stream()
                    .filter(c -> c.getName().equalsIgnoreCase(name))
                    .map(CharacterCollections::characterAddMovie)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    public static List<Character> getAll() {
        try {
            return Generator.addCharacter().stream()
                    .map(CharacterCollections::characterAddMovie)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    public static List<Character> findByAge(int age) {
        List<Character> characters = Generator.addCharacter();
        if (!Validations.validateAgeM0(age) || !Validations.validateAgem0(age)) {
            throw new NumberFormatException("The number entered is not valid");
        }
        try {
            return characters.stream()
                    .filter(c -> c.getAge() == age)
                    .map(CharacterCollections::characterAddMovie)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    public static Character characterAddMovie(Character c) {
        List<Movie> m = Generator.addMovie();
        int nMovie = (int) (Math.random() * 3);
        List<MovieResponse> movieResponses = new ArrayList<>();
        for (int i = 0; i < nMovie; i++) {
            movieResponses.add(MovieMapper.createMovieResponse(m.get(i)));
            c.setListMovie(movieResponses);
        }
        return c;
    }
}


