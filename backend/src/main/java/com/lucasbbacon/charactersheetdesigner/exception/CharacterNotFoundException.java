package com.lucasbbacon.charactersheetdesigner.exception;

public class CharacterNotFoundException extends RuntimeException {
    public CharacterNotFoundException(Long id) {
        super("Character with ID " + id + " not found");
    }
}
