package com.bsb.ejercicio.model.entity;

import java.util.List;

public class Gender {
    private String name;
    private List<Movie> movie;

    public Gender(String name, List<Movie> movie) {
        this.name = name;
        this.movie = movie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovie() {
        return movie;
    }

    public void setMovie(List<Movie> movie) {
        this.movie = movie;
    }
}
