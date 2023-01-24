package com.bsb.ejercicio.controller;

import com.bsb.ejercicio.model.entity.Movie;
import com.bsb.ejercicio.service.MovieCollections;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @GetMapping("title")
    public ResponseEntity<List<Movie>> getMovieTitle(@RequestParam(name = "title", required = false) String title) {
        return ResponseEntity.status(HttpStatus.OK).body(MovieCollections.findTitle(title));
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovieAll() {
        return ResponseEntity.status(HttpStatus.OK).body(MovieCollections.getAll());
    }

    @GetMapping("{gender}")
    public ResponseEntity<List<Movie>> getMovieGender(@PathVariable String gender) {
        return ResponseEntity.status(HttpStatus.OK).body(MovieCollections.findByGender(gender));
    }

    @GetMapping("date")
    public ResponseEntity<List<Movie>> getMovieGender(
            @RequestParam(value = "from", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from,
            @RequestParam(value = "to", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate to
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(MovieCollections.findByDate(from, to));
    }

    @GetMapping("score")
    public ResponseEntity<List<Movie>> getMovieGender(
            @RequestParam(value = "from", required = true) int from,
            @RequestParam(value = "to", required = true) int to
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(MovieCollections.findByScore(from, to));
    }

    @PostMapping()
    public ResponseEntity<List<Movie>> movieAdd(
            @RequestBody Movie movie) {
        return ResponseEntity.status(HttpStatus.OK).body(MovieCollections.movieCreate(movie));
    }

    @PutMapping
    public ResponseEntity<Movie> update(
            @RequestBody Movie movie,
            @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(MovieCollections.update(id, movie));
    }
}
