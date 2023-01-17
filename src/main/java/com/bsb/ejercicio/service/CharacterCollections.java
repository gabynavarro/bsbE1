package com.bsb.ejercicio.service;

import com.bsb.ejercicio.model.entity.Character;
import com.bsb.ejercicio.model.entity.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CharacterCollections {
    private static String[] nameCharater = {"Robert-Downey", "Chris-Evans", "Chris-Hemsworth",
            "Paul-Rudd", "Michael-Douglas",
            "Guy-Pearce", "Don-Cheadle"
    };
    private static String[] descriptionCharacter = {"Earth's mightiest heroes must come together and learn to fight as a team if they are to stop the mischievous Loki and his alien army from enslaving humanity...",
            "Earth's mightiest heroes must come together and learn to fight as a team if they are to stop the mischievous Loki and his alien army from enslaving humanity...",
            "Armed with a super-suit with the astonishing ability to shrink in scale but increase in strength, cat burglar Scott Lang must embrace his inner hero and help...",
            "When Tony Stark's world is torn apart by a formidable terrorist called the Mandarin, he starts an odyssey of rebuilding and retribution."
    };

    public static List<Character> addCharacter() {
        List<Character> colectionCharacter = new ArrayList<>();
        List<Movie> movie = new ArrayList<>();
        colectionCharacter.add(new Character(nameCharater[1],63,65.5,descriptionCharacter[0], movie));
        colectionCharacter.add(new Character(nameCharater[2],65,62.7,descriptionCharacter[0], movie));
        colectionCharacter.add(new Character(nameCharater[0],65,61.3,descriptionCharacter[3], movie));
        colectionCharacter.add(new Character(nameCharater[1],65,68.7,descriptionCharacter[3], movie));
        colectionCharacter.add(new Character(nameCharater[2],65,64.7,descriptionCharacter[3], movie));
        colectionCharacter.add(new Character(nameCharater[3],38,72.5,descriptionCharacter[2], movie));
        colectionCharacter.add(new Character(nameCharater[4],38,82.5,descriptionCharacter[2], movie));
        colectionCharacter.add(new Character(nameCharater[5],24,62.1,descriptionCharacter[1], movie));
        colectionCharacter.add(new Character(nameCharater[6],52,71.2,descriptionCharacter[1], movie));

        return colectionCharacter;
    }

    public static Character findName(String name) {
        if(name == null&&!Validations.validationString(name)) throw new NullPointerException("Character name can't be null or contains invalid characters");

        List<Character> characters = addCharacter();
        return characters.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList()).get(0);
    }

    public static List<Character> getAll() {
        List<Character> character = addCharacter();
        return character;
    }

    public static List<Character> findByAge(int age) {
        List<Character> character = addCharacter();
        if (Validations.validateAgeM0(age) || Validations.validateAgem0(age)) {
            throw new NumberFormatException("The number entered is not valid");
        }
        return character;
    }
}


