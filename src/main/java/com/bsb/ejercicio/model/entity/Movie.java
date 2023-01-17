package com.bsb.ejercicio.model.entity;

import java.time.LocalDate;
import java.util.List;

public class Movie {
   private  String title;
   private LocalDate date;
   private int score;
   private List<Character> character;

    public Movie(String title, LocalDate date, int score, List<Character> character) {
        this.title = title;
        this.date = date;
        this.score = score;
        this.character = character;
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

    public List<Character> getCharacter() {
        return character;
    }

    public void setCharacter(List<Character> character) {
        this.character = character;
    }
}
