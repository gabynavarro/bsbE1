package com.bsb.ejercicio.controller;

import com.bsb.ejercicio.model.entity.Character;
import com.bsb.ejercicio.service.CharacterCollections;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CharacterController {
    @GetMapping("/character/{name}")
    public Character getCharacterName(@PathVariable String name)
    {
        System.out.println("Controller de name: " +name );
        return CharacterCollections.findName(name);
    }
    @GetMapping("/character")
    public List<Character> getCharacterName()
    {
        return CharacterCollections.getAll();
    }

    @GetMapping("/characters/{age}")
    public List<Character> getCharacterAge( @PathVariable int age)
    {
        return CharacterCollections.findByAge(age);
    }

}
