// model/Character.java
package com.lucasbbacon.charactersheetdesigner.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Objects;

@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 50, message = "Name must be less than 50 characters")
    private String name;

    @NotNull(message = "Race is mandatory")
    private Race race;

    @NotNull(message = "Class is mandatory")
    private CharacterClass characterClass;

    @NotBlank(message = "Background is mandatory")
    private String background;

    @NotBlank(message = "Alignment is mandatory")
    private String alignment;

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

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(CharacterClass characterClass) {
        this.characterClass = characterClass;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
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
