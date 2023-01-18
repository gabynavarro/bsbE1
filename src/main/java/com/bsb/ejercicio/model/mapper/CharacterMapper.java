package com.bsb.ejercicio.model.mapper;

import com.bsb.ejercicio.model.dto.CharacterResponse;
import com.bsb.ejercicio.model.entity.Character;

public class CharacterMapper {
    public static CharacterResponse createMovieResponse(Character c) {
        CharacterResponse response = new CharacterResponse();
        response.setName(c.getName());
        return response;
    }
}
