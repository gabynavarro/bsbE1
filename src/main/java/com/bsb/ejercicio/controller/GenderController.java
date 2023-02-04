package com.bsb.ejercicio.controller;

import com.bsb.ejercicio.model.entity.Gender;
import com.bsb.ejercicio.service.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gender")
public class GenderController {
    @Autowired
    private IGenderService genderService;
    @GetMapping
    public  ResponseEntity<List<Gender>> getGender() {
        return  ResponseEntity.status(HttpStatus.OK).body(genderService.getAll());
    }
    @PostMapping
    public ResponseEntity<List<Gender>> genderAdd(
            @RequestBody Gender gender) {
        return ResponseEntity.status(HttpStatus.OK).body(genderService.genderCreate(gender));
    }
    @GetMapping(value = "{id}")
    public  ResponseEntity<Gender> getGender(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(genderService.findById(id));
    }
}
