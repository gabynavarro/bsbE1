package com.bsb.ejercicio.service;

import com.bsb.ejercicio.model.entity.Movie;
import com.bsb.ejercicio.validations.Validations;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MovieCollections {
    private static final String ERROR_NOT_FOUND = "An error occurred in the process";
    private static final String ERROR_NOT_VALIDATE="The data entered contains erroneous information";
    public static List<Movie> findTitle(String title) {
        if (title == null && !Validations.validationString(title))
            throw new NullPointerException("Movie name can't be null or contains invalid characters");
        List<Movie> movies = Generator.addMovie();
        try {
            return movies.stream()
                    .filter(m -> m.getTitle().equalsIgnoreCase(title))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }

    }

    public static List<Movie> getAll() {
        try {
            return new ArrayList<>(Generator.addMovie());
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }

    }

    public static List<Movie> findByGender(String gender) {
        List<Movie> movies = Generator.addMovie();
        if (gender == null && !Validations.validationString(gender)) {
            throw new NumberFormatException("Movie name gender can't be null or contains invalid characters");
        }
        try {
            return movies.stream()
                    .filter(m -> m.getGender().getName().equalsIgnoreCase(gender))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    public static List<Movie> findByDate(LocalDate from, LocalDate to) {
        try {
            List<Movie> movies = Generator.addMovie();
            return movies.stream()
                    .filter(m -> m.getDate().isAfter(from) && m.getDate().isBefore(to))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    public static List<Movie> findByScore(int from, int to) {
        try {
            List<Movie> movies = Generator.addMovie();
            return movies.stream()
                    .filter(m -> m.getScore() >= from && m.getScore() <= to)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    public static List<Movie> movieCreate(Movie movie) {
        try {
            List<Movie> movies = getAll();
            if (!Validations.validateMovieEntity(movie))
                throw new RuntimeException(ERROR_NOT_VALIDATE);
            movie.setId((long) (movies.size() + 1));
            movies.add(movie);
            return movies;
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    public static Movie findById(Long id) {
        try {
            List<Movie> movies = getAll();
            return movies.stream().filter(g -> Objects.equals(g.getId(), id)).findFirst().orElse(null);
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    public static Movie update(Long id, Movie movie) {
        try {
            Movie m = findById(id);
            if(!Validations.validateMovieEntity(movie))
                throw new RuntimeException(ERROR_NOT_VALIDATE);
            if (m!=null) {
                m.setTitle(movie.getTitle());
                m.setDate(movie.getDate());
                m.setScore(movie.getScore());
                return m;
            } else throw new NullPointerException("The id entered is incorrect or deleted");
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }
}
