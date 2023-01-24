package com.bsb.ejercicio.controller;

import com.bsb.ejercicio.model.entity.Character;
import com.bsb.ejercicio.model.entity.Gender;
import com.bsb.ejercicio.service.CharacterCollections;
import com.bsb.ejercicio.service.GenderCollections;
import com.bsb.ejercicio.validations.Validations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gender")
public class GenderController {
    @GetMapping
    public  ResponseEntity<List<Gender>> getGender() {
        return  ResponseEntity.status(HttpStatus.OK).body(GenderCollections.getAll());
    }
    @PostMapping
    public ResponseEntity<List<Gender>> genderAdd(
            @RequestBody Gender gender) {
        return ResponseEntity.status(HttpStatus.OK).body(GenderCollections.genderCreate(gender));
    }
    @GetMapping(value = "{id}")
    public  ResponseEntity<Gender> getGender(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(GenderCollections.findById(id));
    }
}
