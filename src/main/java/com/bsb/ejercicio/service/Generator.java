package com.bsb.ejercicio.service;

import com.bsb.ejercicio.model.dto.CharacterResponse;
import com.bsb.ejercicio.model.dto.MovieResponse;
import com.bsb.ejercicio.model.entity.Character;
import com.bsb.ejercicio.model.entity.Gender;
import com.bsb.ejercicio.model.entity.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Generator {
    private static final String[] nameCharater = {"Robert-Downey", "Chris-Evans", "Chris-Hemsworth",
            "Paul-Rudd", "Michael-Douglas",
            "Guy-Pearce", "Don-Cheadle"
    };
    private static final String[] descriptionCharacter = {"Earth's mightiest heroes must come together and learn to fight as a team if they are to stop the mischievous Loki and his alien army from enslaving humanity...",
            "Earth's mightiest heroes must come together and learn to fight as a team if they are to stop the mischievous Loki and his alien army from enslaving humanity...",
            "Armed with a super-suit with the astonishing ability to shrink in scale but increase in strength, cat burglar Scott Lang must embrace his inner hero and help...",
            "When Tony Stark's world is torn apart by a formidable terrorist called the Mandarin, he starts an odyssey of rebuilding and retribution."
    };

    private static final String[] titleMovie = {"Oblivion",
            "Titanic",
            "IronMan",
            "Mulholland"};
    private static final LocalDate[] date = {LocalDate.parse("2012-01-08"),
            LocalDate.parse("2014-08-15"),
            LocalDate.parse("2015-02-15"),
            LocalDate.parse("2013-10-15")};

    public static List<Gender> addGender() {
        List<Gender> listGender = new ArrayList<>();
        listGender.add(new Gender("Suspenso"));
        listGender.add(new Gender("Terror"));
        listGender.add(new Gender("Suspenso"));
        listGender.add(new Gender("Comedia"));
        return listGender;
    }

    public static List<Character> addCharacter() {
        List<Character> colectionCharacter = new ArrayList<>();
        List<MovieResponse> iterator = new ArrayList<>();
        colectionCharacter.add(new Character(nameCharater[0], 63, 65.5, descriptionCharacter[0], iterator));
        colectionCharacter.add(new Character(nameCharater[1], 65, 62.7, descriptionCharacter[0], iterator));
        colectionCharacter.add(new Character(nameCharater[2], 65, 61.3, descriptionCharacter[0], iterator));
        colectionCharacter.add(new Character(nameCharater[3], 65, 68.7, descriptionCharacter[3], iterator));
        colectionCharacter.add(new Character(nameCharater[4], 65, 64.7, descriptionCharacter[3], iterator));
        colectionCharacter.add(new Character(nameCharater[5], 38, 72.5, descriptionCharacter[2], iterator));
        colectionCharacter.add(new Character(nameCharater[6], 38, 82.5, descriptionCharacter[2], iterator));
        return colectionCharacter;
    }

    public static List<Movie> addMovie() {
        List<Movie> listMovie = new ArrayList<>();
        List<Gender> listGender= addGender();
        List<CharacterResponse> iterator = new ArrayList<>();
        listMovie.add(new Movie(titleMovie[0], date[0], 3, iterator,listGender.get(0)));
        listMovie.add(new Movie(titleMovie[1], date[1], 2, iterator,listGender.get(1)));
        listMovie.add(new Movie(titleMovie[2], date[2], 5, iterator,listGender.get(2)));
        listMovie.add(new Movie(titleMovie[3], date[3], 4, iterator,listGender.get(3)));
        return listMovie;
    }
}
