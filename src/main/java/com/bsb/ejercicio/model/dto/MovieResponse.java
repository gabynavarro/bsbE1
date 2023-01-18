package com.bsb.ejercicio.model.dto;

import com.bsb.ejercicio.model.entity.Movie;

import java.time.LocalDate;

public class MovieResponse {
    private String title;
    private LocalDate date;
    private int score;

    public MovieResponse(String title, LocalDate date, int score) {
        this.title = title;
        this.date = date;
        this.score = score;
    }

    public MovieResponse() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
