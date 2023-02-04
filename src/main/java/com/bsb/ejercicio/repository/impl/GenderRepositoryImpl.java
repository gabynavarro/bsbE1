package com.bsb.ejercicio.repository.impl;

import com.bsb.ejercicio.model.entity.Gender;
import com.bsb.ejercicio.repository.GenderRepository;
import com.bsb.ejercicio.repository.Generator;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class GenderRepositoryImpl implements GenderRepository {
    @Override
    public List<Gender> getAll() {
       return  new ArrayList<>(Generator.addGender());
    }

    @Override
    public List<Gender> genderCreate(Gender gender) {
        List<Gender> genders = getAll();
        gender.setId((long) (genders.size() + 1));
        genders.add(gender);
        return genders;
    }

    @Override
    public Gender findById(Long id) {
        List<Gender> genders = getAll();
        return genders.stream().filter(g-> Objects.equals(g.getId(), id)).findFirst().orElse(null);
    }

}
