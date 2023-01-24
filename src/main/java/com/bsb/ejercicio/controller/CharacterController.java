package com.bsb.ejercicio.controller;

import com.bsb.ejercicio.model.entity.Character;
import com.bsb.ejercicio.service.CharacterCollections;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {
    @GetMapping("name")
    public ResponseEntity<List<Character>> getCharacterName(@RequestParam(value = "name", required = false) String name) {
        return ResponseEntity.status(HttpStatus.OK).body(CharacterCollections.findName(name));
    }

    @GetMapping
    public ResponseEntity<List<Character>> getCharacterName() {
        return ResponseEntity.status(HttpStatus.OK).body(CharacterCollections.getAll());
    }

    @GetMapping(value = "/age/{age}")
    public ResponseEntity<List<Character>> getCharacterAge(@PathVariable int age) {
        return ResponseEntity.status(HttpStatus.OK).body(CharacterCollections.findByAge(age));
    }

    @GetMapping(value = "age")
    public ResponseEntity<List<Character>> getCharacterRangeAge(
            @RequestParam int from, @RequestParam int to) {
        return ResponseEntity.status(HttpStatus.OK).body(CharacterCollections.findByRangeAge(from, to));
    }

    @PostMapping
    public ResponseEntity<List<Character>> characterAdd(
            @RequestBody Character character) {
        return ResponseEntity.status(HttpStatus.OK).body(CharacterCollections.characterCreate(character));
    }

    @PutMapping
    public ResponseEntity<Character> update(
            @RequestBody Character character,
            @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(CharacterCollections.update(id, character));
    }
}
