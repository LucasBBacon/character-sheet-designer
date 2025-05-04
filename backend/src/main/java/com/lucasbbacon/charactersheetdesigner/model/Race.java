package com.lucasbbacon.charactersheetdesigner.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Race {
    HUMAN,
    ELF,
    DWARF,
    HALFLING,
    ORC,
    GOBLIN,
    TIEFLING,
    DRAGONBORN,
    AASIMAR,
    GENASI,
    KOBOLD,
    BUGBEAR,
    FIRBOLG,
    TABAXI,
    TORTLE,
    LIZARDFOLK,
    CENTAUR,
    MINOTAUR,
    SATYR,
    YUAN_TI;

    @JsonCreator
    public static Race fromString(String value) {
        return Race.valueOf(value.toUpperCase());
    }
}
