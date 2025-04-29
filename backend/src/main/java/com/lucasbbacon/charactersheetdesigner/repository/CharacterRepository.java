package com.lucasbbacon.charactersheetdesigner.repository;

import com.lucasbbacon.charactersheetdesigner.model.Character;
import com.lucasbbacon.charactersheetdesigner.model.CharacterClass;
import com.lucasbbacon.charactersheetdesigner.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    List<Character> findByRace(Race race);
    List<Character> findByCharacterClass(CharacterClass characterClass);
}
