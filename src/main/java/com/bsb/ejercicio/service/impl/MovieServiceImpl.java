package com.bsb.ejercicio.service.impl;

import com.bsb.ejercicio.model.entity.Movie;
import com.bsb.ejercicio.model.mappers.MovieMapper;
import com.bsb.ejercicio.model.request.MovieRequest;
import com.bsb.ejercicio.model.response.CharacterMovieResponse;
import com.bsb.ejercicio.model.response.MovieResponse;
import com.bsb.ejercicio.repository.MovieRepository;
import com.bsb.ejercicio.service.IMovieService;
import com.bsb.ejercicio.validations.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MovieServiceImpl implements IMovieService {
    private static final String ERROR_NOT_FOUND = "An error occurred in the process";
    private static final String ERROR_NOT_VALIDATE = "The data entered contains erroneous information";
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieMapper movieMapper;
    private List<MovieResponse> converTo(List<Movie> list) {       //borrar
        return list.stream()
                .map(m -> movieMapper.toMovieResponse(m))
                .collect(Collectors.toList());
    }
    @Override
    public List<MovieResponse> findTitle(String title) {
        if (title == null && !Validations.validationString(title))
            throw new NullPointerException("Movie name can't be null or contains invalid characters");
        try {
            return converTo(movieRepository.findTitle(title));
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    @Override
    public List<MovieResponse> getAll() {
        try {
            return converTo(movieRepository.getAll());
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    @Override
    public List<MovieResponse> findByGender(String gender) {
        if (gender == null && !Validations.validationString(gender)) {
            throw new NumberFormatException("Movie name gender can't be null or contains invalid characters");
        }
        try {
            return converTo(movieRepository.findByGender(gender));
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    @Override
    public List<MovieResponse> findByDate(LocalDate from, LocalDate to) {
        try {
            return converTo(movieRepository.findByDate(from, to));
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    @Override
    public List<MovieResponse> findByScore(int from, int to) {
        try {
            return converTo(movieRepository.findByScore(from, to));

        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    @Override
    public List<MovieResponse> movieCreate(MovieRequest movie) {
        try {
            if (!Validations.validateMovieEntity(movie))
                throw new RuntimeException(ERROR_NOT_VALIDATE);
            return converTo(movieRepository.movieCreate(movieMapper.toEntity(movie)));
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    @Override
    public MovieResponse findById(Long id) {
        try {
            return movieMapper.toMovieResponse(movieRepository.findById(id));

        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    @Override
    public MovieResponse update(Long id, MovieRequest movie) {
        try {
            Movie m = movieRepository.findById(id);
            if (Validations.validateMovieEntity(movie))
                throw new RuntimeException(ERROR_NOT_VALIDATE);

            if (m != null) {
                m.setTitle(movie.getTitle());
                m.setDate(movie.getDate());
                m.setScore(movie.getScore());
                return movieMapper.toMovieResponse(m);
            } else throw new NullPointerException("The id entered is incorrect or deleted");
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }
}