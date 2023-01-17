package com.bsb.ejercicio.model.entity;

import java.util.List;

public class Character {
   private String name;
   private Integer age;
   private Double weight;
   private String history;
   private List<Movie> listMovie;

    public Character(String name, Integer age, Double weight, String history, List<Movie> listMovie) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.history = history;
        this.listMovie = listMovie;
    }

    public Character() {

    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public void setHistory(String history) {
        this.history = history;
    }
    public void setListMovie(List<Movie> listMovie) {
        this.listMovie = listMovie;
    }
    public Integer getAge() {
        return age;
    }
    public Double getWeight() {
        return weight;
    }
    public String getHistory() {
        return history;
    }
    public List<Movie> getListMovie() {
        return listMovie;
    }
    public String getName() {
        return name;
    }
}
