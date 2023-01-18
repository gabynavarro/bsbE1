package com.bsb.ejercicio.model.entity;

import com.bsb.ejercicio.model.dto.CharacterResponse;

import java.time.LocalDate;
import java.util.List;

public class Movie {
    private String title;
    private LocalDate date;
    private int score;
    private List<CharacterResponse> character;
    private Gender gender;


    public Movie(String title, LocalDate date, int score, List<CharacterResponse> character, Gender gender) {
        this.title = title;
        this.date = date;
        this.score = score;
        this.character = character;
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public List<CharacterResponse> getCharacter() {
        return character;
    }

    public void setCharacter(List<CharacterResponse> character) {
        this.character = character;
    }
}
