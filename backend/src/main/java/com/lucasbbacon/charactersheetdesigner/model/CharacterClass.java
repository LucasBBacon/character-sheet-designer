package com.lucasbbacon.charactersheetdesigner.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CharacterClass {
    BARBARIAN,
    BARD,
    CLERIC,
    DRUID,
    FIGHTER,
    MONK,
    PALADIN,
    RANGER,
    ROGUE,
    SORCERER,
    WARLOCK,
    WIZARD,
    ARTIFICER,
    BLOOD_HUNTER;

    @JsonCreator
    public static CharacterClass fromString(String value) {
        return CharacterClass.valueOf(value.toUpperCase());
    }
}
