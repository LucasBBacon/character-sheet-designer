package com.lucasbbacon.charactersheetdesigner.service;

import com.lucasbbacon.charactersheetdesigner.model.Character;

import com.lucasbbacon.charactersheetdesigner.model.CharacterClass;
import com.lucasbbacon.charactersheetdesigner.model.Race;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CharacterServiceTest {

    @Test
    void testCreateCharacter() {
        CharacterService service = new CharacterService();
        Character character = new Character();
        character.setName("Test");
        character.setRace(Race.ELF);
        character.setCharacterClass(CharacterClass.WIZARD);

        Character created = service.createCharacter(character);
        assertNotNull(created.getId());
        assertEquals("Test", created.getName());
    }

    @Test
    void testGetCharacter() {
        CharacterService service = new CharacterService();
        Character character = new Character();
        character.setName("Test");
        character.setRace(Race.ELF);
        character.setCharacterClass(CharacterClass.WIZARD);

        Character created = service.createCharacter(character);
        Character fetched = service.getCharacter(created.getId());

        assertNotNull(fetched);
        assertEquals(created.getId(), fetched.getId());
        assertEquals("Test", fetched.getName());
    }
}
