package com.lucasbbacon.charactersheetdesigner.util;

import com.lucasbbacon.charactersheetdesigner.model.Character;

public class CharacterTestFactory {

    public static Character createValidCharacter() {
        Character character = new Character();
        character.setName("Test");
        character.setRace("Elf");
        character.setCharacterClass("Wizard");
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
        character.setRace(""); // Invalid
        return character;
    }

    public static Character createCharacterWithInvalidClass() {
        Character character = createValidCharacter();
        character.setCharacterClass(""); // Invalid
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
}