package com.bsb.ejercicio.validations;

import com.bsb.ejercicio.model.entity.Character;
import com.bsb.ejercicio.model.entity.Movie;


public class Validations {

    public static boolean validationString(String text) {
        return text.matches("^[a-zA-Z]+$");
    }

    public static boolean validateAgeM0(int age) {
        return age > 0;
    }

    public static boolean validateAgem0(int age) {
        return age < 120;
    }
    public static boolean validateMovieEntity(Movie movie){
        if(!validationString(movie.getTitle())) return true;
        if(movie.getScore()<0&&movie.getScore()>5) return true;
        return false;
    } public static boolean validateCharacterEntity(Character character){
        if(!validationString(character.getName())) return true;
        if(character.getAge()<0&&character.getAge()>125) return true;
        return false;
    }
}
