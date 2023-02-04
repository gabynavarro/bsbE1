package com.bsb.ejercicio.service.impl;

import com.bsb.ejercicio.model.entity.Gender;
import com.bsb.ejercicio.repository.GenderRepository;
import com.bsb.ejercicio.service.IGenderService;
import com.bsb.ejercicio.validations.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderServiceImpl implements IGenderService {
    private  final String ERROR_NOT_FOUND = "An error occurred in the process";
    @Autowired
    private GenderRepository genderRepository;

    @Override
    public List<Gender> getAll() {
        try {
            return genderRepository.getAll();
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    @Override
    public List<Gender> genderCreate(Gender gender) {
        try {
            return genderRepository.genderCreate(gender);
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    @Override
    public Gender findById(Long id) {
        try {
            return genderRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }

    @Override
    public Gender update(Long id, Gender gender) {
        try {
            Gender m = genderRepository.findById(id);
            if (!Validations.validationString(gender.getName()))
                throw new RuntimeException("He entered an invalid name");
            if (m != null) {
                m.setName(gender.getName());
                return m;
            } else throw new NullPointerException("The id entered is incorrect or deleted");
        } catch (Exception e) {
            throw new RuntimeException(ERROR_NOT_FOUND);
        }
    }
}

