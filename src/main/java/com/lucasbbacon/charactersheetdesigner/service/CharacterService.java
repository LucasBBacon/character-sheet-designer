package com.lucasbbacon.charactersheetdesigner.service;

import com.lucasbbacon.charactersheetdesigner.exception.CharacterNotFoundException;
import com.lucasbbacon.charactersheetdesigner.model.Character;

import com.lucasbbacon.charactersheetdesigner.model.CharacterClass;
import com.lucasbbacon.charactersheetdesigner.model.Race;
import com.lucasbbacon.charactersheetdesigner.repository.CharacterRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    private final CharacterRepository repository;

    public CharacterService(CharacterRepository repository) {
        this.repository = repository;
    }

    public Character createCharacter(Character character) {
        return repository.save(character);
    }

    public Character getCharacter(Long id) {
        return repository.findById(id).orElseThrow(() -> new CharacterNotFoundException(id));
    }

    public List<Character> getAllCharacters() {
        return repository.findAll();
    }

    public Character updateCharacter(Long id, Character updatedCharacter) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setName(updatedCharacter.getName());
                    existing.setRace(updatedCharacter.getRace());
                    existing.setCharacterClass(updatedCharacter.getCharacterClass());
                    existing.setBackground(updatedCharacter.getBackground());
                    existing.setAlignment(updatedCharacter.getAlignment());
                    existing.setStrength(updatedCharacter.getStrength());
                    existing.setDexterity(updatedCharacter.getDexterity());
                    existing.setConstitution(updatedCharacter.getConstitution());
                    existing.setIntelligence(updatedCharacter.getIntelligence());
                    existing.setWisdom(updatedCharacter.getWisdom());
                    existing.setCharisma(updatedCharacter.getCharisma());
                    return repository.save(existing);
                })
                .orElse(null);
    }

    public void deleteCharacter(Long id) {
        repository.deleteById(id);
    }

    public List<Character> getCharacterByRace(Race race) {
        return repository.findByRace(race);
    }

    public List<Character> getCharacterByClass(CharacterClass characterClass) {
        return repository.findByCharacterClass(characterClass);
    }
}
