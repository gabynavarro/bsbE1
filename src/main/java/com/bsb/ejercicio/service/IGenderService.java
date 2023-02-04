package com.bsb.ejercicio.service;

import com.bsb.ejercicio.model.entity.Gender;

import java.util.List;

public interface IGenderService {
    List<Gender> getAll();
    List<Gender> genderCreate(Gender gender);
    Gender findById(Long id);
    Gender update(Long id, Gender gender);
}
