package com.lucasbbacon.charactersheetdesigner.util;

import com.lucasbbacon.charactersheetdesigner.model.Character;
import com.lucasbbacon.charactersheetdesigner.model.CharacterClass;
import com.lucasbbacon.charactersheetdesigner.model.Race;

public class CharacterTestFactory {

    public static Character createValidCharacter() {
        Character character = new Character();
        character.setName("Test");
        character.setRace(Race.ELF);
        character.setCharacterClass(CharacterClass.WIZARD);
        character.setBackground("Noble");
        character.setAlignment("Chaotic Good");
        character.setStrength(10);
        character.setDexterity(14);
        character.setConstitution(12);
        character.setIntelligence(15);
        character.setWisdom(13);
        character.setCharisma(11);
        return character;
    }

    public static Character createCharacterWithInvalidName() {
        Character character = createValidCharacter();
        character.setName(""); // Invalid name
        return character;
    }

    public static Character createCharacterWithInvalidRace() {
        Character character = createValidCharacter();
        character.setRace(null); // Invalid
        return character;
    }

    public static Character createCharacterWithInvalidClass() {
        Character character = createValidCharacter();
        character.setCharacterClass(null); // Invalid
        return character;
    }

    public static Character createCharacterWithInvalidStrength() {
        Character character = createValidCharacter();
        character.setStrength(25); // Invalid strength
        return character;
    }

    public static Character createCharacterWithInvalidDexterity() {
        Character character = createValidCharacter();
        character.setDexterity(0); // Invalid dexterity
        return character;
    }

    public static Character createCharacterWithMissingBackground() {
        Character character = createValidCharacter();
        character.setBackground(""); // Missing background
        return character;
    }

    public static Character createCharacterWithMissingAlignment() {
        Character character = createValidCharacter();
        character.setAlignment(""); // Missing alignment
        return character;
    }
}