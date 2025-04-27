package com.lucasbbacon.charactersheetdesigner.service;

import com.lucasbbacon.charactersheetdesigner.model.Character;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CharacterService {

    private final Map<Long, Character> characters = new HashMap<>();
    private Long nextId = 1L;

    public Character createCharacter(Character character) {
        character.setId(nextId++);
        characters.put(character.getId(), character);
        return character;
    }

    public Character getCharacter(Long id) {
        return characters.get(id);
    }

}
