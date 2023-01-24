package com.bsb.ejercicio.model.entity;

import com.bsb.ejercicio.model.dto.MovieResponse;

import java.util.List;

public class Character {
    private Long id;
    private String name;
    private Integer age;
    private Double weight;
    private String history;

    public void setListMovie(List<MovieResponse> listMovie) {
        this.listMovie = listMovie;
    }

    private List<MovieResponse> listMovie;

    public Character(Long id, String name, Integer age, Double weight, String history, List<MovieResponse> listMovie) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.history = history;
        this.listMovie = listMovie;
    }

    public Character() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public List<MovieResponse> getListMovie() {
        return listMovie;
    }
}
