package com.bsb.ejercicio.service;

import com.bsb.ejercicio.model.entity.Character;
import com.bsb.ejercicio.model.entity.Movie;
import com.bsb.ejercicio.validations.Validations;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CharacterCollections {
    private static final String ERROR_NOT_FOUND = "An error occurred in the process";
    private static final String ERROR_NOT_VALIDATE="The data entered contains erroneous information";
    public static List<Character> findName(String name) {
        try {

            if (name == null && !Validations.validationString(name))
                throw new NullPointerException("Character name can't be null or contains invalid characters");
            List<Character> characters = Generator.addCharacter();
            return characters.stream().filter(c -> c.getName().equalsIgnoreCase(name)).collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    public static List<Character> getAll() {
        try {
            return new ArrayList<>(Generator.addCharacter());
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    public static List<Character> findByAge(int age) {
        List<Character> characters = Generator.addCharacter();
        if (!Validations.validateAgeM0(age) || !Validations.validateAgem0(age)) {
            throw new NumberFormatException("The number entered is not valid");
        }
        try {
            return characters.stream().filter(c -> c.getAge() == age).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    public static List<Character> findByRangeAge(int from, int to) {
        try {
            List<Character> characters = Generator.addCharacter();
            return characters.stream()
                    .filter(c -> c.getAge() >= from && c.getAge() <= to)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    public static List<Character> characterCreate(Character character) {
        try {
            List<Character> characters = getAll();
            if (!Validations.validateCharacterEntity(character))
                throw new RuntimeException(ERROR_NOT_VALIDATE);
            character.setId((long) (characters.size() + 1));
            characters.add(character);
            return characters;
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    public static Character findById(Long id) {
        try {
            List<Character> characters = getAll();
            return characters.stream().filter(g -> Objects.equals(g.getId(), id)).findFirst().orElse(null);
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }
    public static Character update(Long id, Character character) {
        try {
            Character c = findById(id);
            if(Validations.validateCharacterEntity(character))
                throw new RuntimeException(ERROR_NOT_VALIDATE);
            if (c!=null) {
                c.setName(character.getName());
                c.setAge(character.getAge());
                c.setHistory(character.getHistory());
                c.setWeight(character.getWeight());
                return c;
            } else throw new NullPointerException("The id entered is incorrect or deleted");
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }
}


