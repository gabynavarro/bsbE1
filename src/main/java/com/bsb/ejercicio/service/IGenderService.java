package com.bsb.ejercicio.service;

import com.bsb.ejercicio.model.entity.Gender;
import com.bsb.ejercicio.model.response.GenderResponse;

import java.util.List;

public interface IGenderService {
    List<GenderResponse> getAll();
    List<GenderResponse> genderCreate(Gender gender);
    GenderResponse findById(Long id);
    GenderResponse update(Long id, Gender gender);
}
