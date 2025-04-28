// model/Character.java
package com.lucasbbacon.charactersheetdesigner.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Character {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 50, message = "Name must be less than 50 characters")
    private String name;

    @NotBlank(message = "Race is mandatory")
    private String race;

    @NotBlank(message = "Class is mandatory")
    private String characterClass;

    @Min(value = 1, message = "Strength must be at least 1")
    @Max(value = 20, message = "Strength must be at most 20")
    private int strength;

    @Min(value = 1, message = "Dexterity must be at least 1")
    @Max(value = 20, message = "Dexterity must be at most 20")
    private int dexterity;

    @Min(value = 1, message = "Constitution must be at least 1")
    @Max(value = 20, message = "Constitution must be at most 20")
    private int constitution;

    @Min(value = 1, message = "Intelligence must be at least 1")
    @Max(value = 20, message = "Intelligence must be at most 20")
    private int intelligence;

    @Min(value = 1, message = "Wisdom must be at least 1")
    @Max(value = 20, message = "Wisdom must be at most 20")
    private int wisdom;

    @Min(value = 1, message = "Charisma must be at least 1")
    @Max(value = 20, message = "Charisma must be at most 20")
    private int charisma;

    // Constructors, getters, and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(id, character.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
