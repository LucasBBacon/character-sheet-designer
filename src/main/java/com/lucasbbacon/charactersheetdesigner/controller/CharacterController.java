package com.lucasbbacon.charactersheetdesigner.controller;

import com.lucasbbacon.charactersheetdesigner.model.Character;
import com.lucasbbacon.charactersheetdesigner.model.CharacterClass;
import com.lucasbbacon.charactersheetdesigner.model.Race;
import com.lucasbbacon.charactersheetdesigner.service.CharacterService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping
    @Validated
    public Character createCharacter(@RequestBody @Valid Character character) {
        return characterService.createCharacter(character);
    }

    @GetMapping("/{id}")
    public Character getCharacter(@PathVariable Long id) {
        return characterService.getCharacter(id);
    }

    @GetMapping("/races")
    public List<String> getAllRaces() {
        return Arrays.stream(Race.values()).map(Enum::name).toList();
    }

    @GetMapping("/classes")
    public List<String> getAllClasses() {
        return Arrays.stream(CharacterClass.values()).map(Enum::name).toList();
    }
}
