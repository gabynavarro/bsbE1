package com.bsb.ejercicio.model.dto;

public class CharacterResponse {
    private String name;

    public CharacterResponse(String name) {
        this.name = name;
    }
    public CharacterResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
