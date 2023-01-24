package com.bsb.ejercicio.service;

import com.bsb.ejercicio.model.entity.Gender;
import com.bsb.ejercicio.validations.Validations;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenderCollections {
    private static final String ERROR_NOT_FOUND = "An error occurred in the process";

    public static List<Gender> getAll() {
        try {
            return new ArrayList<>(Generator.addGender());
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    public static List<Gender> genderCreate(Gender gender) {
        try {
            List<Gender> genders = getAll();
            gender.setId((long) (genders.size() + 1));
            genders.add(gender);
            return genders;
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }
    public static Gender findById(Long id) {
        try {
            List<Gender> genders = getAll();
            return genders.stream().filter(g-> Objects.equals(g.getId(), id)).findFirst().orElse(null);
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }
    public static Gender update(Long id, Gender gender) {
        try {
            Gender m = findById(id);
            if(!Validations.validationString(gender.getName()))
                throw new RuntimeException("He entered an invalid name");
            if (m!=null) {
                m.setName(gender.getName());
                return m;
            } else throw new NullPointerException("The id entered is incorrect or deleted");
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }
}
