package com.bsb.ejercicio.model.entity;

import com.bsb.ejercicio.model.dto.CharacterResponse;

import java.time.LocalDate;
import java.util.List;

public class Movie {
    private Long id;
    private String title;
    private LocalDate date;
    private int score;
    private List<CharacterResponse> character;
    private Gender gender;
    public Movie(Long id, String title, LocalDate date, int score, List<CharacterResponse> character, Gender gender) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.score = score;
        this.character = character;
        this.gender = gender;

    }

    public Movie() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<CharacterResponse> getCharacter() {
        return character;
    }

    public void setCharacter(List<CharacterResponse> character) {
        this.character = character;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}