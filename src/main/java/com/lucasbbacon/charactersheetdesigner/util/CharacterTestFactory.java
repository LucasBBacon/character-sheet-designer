package com.lucasbbacon.charactersheetdesigner.util;

import com.lucasbbacon.charactersheetdesigner.model.Character;

public class CharacterTestFactory {

    public static Character createValidCharacter() {
        Character character = new Character();
        character.setName("Test");
        character.setRace("Elf");
        character.setCharacterClass("Wizard");
        return character;
    }

    public static Character createCharacterWithInvalidName() {
        Character character = createValidCharacter();
        character.setName(""); // Invalid name
        return character;
    }

    public static Character createCharacterWithInvalidRace() {
        Character character = createValidCharacter();
        character.setRace(""); // Invalid
        return character;
    }

    public static Character createCharacterWithInvalidClass() {
        Character character = createValidCharacter();
        character.setCharacterClass(""); // Invalid
        return character;
    }
}