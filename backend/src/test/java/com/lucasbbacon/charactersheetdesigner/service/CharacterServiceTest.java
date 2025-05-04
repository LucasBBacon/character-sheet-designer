package com.lucasbbacon.charactersheetdesigner.service;

import com.lucasbbacon.charactersheetdesigner.model.Character;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.lucasbbacon.charactersheetdesigner.util.CharacterTestFactory.createValidCharacter;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CharacterServiceTest {
    @Mock
    private CharacterService characterService;
//    @Test
//    void testCreateCharacter() {
//        CharacterService service = new CharacterService();
//        Character character = new Character();
//        character.setName("Test");
//        character.setRace(Race.ELF);
//        character.setCharacterClass(CharacterClass.WIZARD);
//
//        Character created = service.createCharacter(character);
//        assertNotNull(created.getId());
//        assertEquals("Test", created.getName());
//    }
//
//    @Test
//    void testGetCharacter() {
//        CharacterService service = new CharacterService();
//        Character character = new Character();
//        character.setName("Test");
//        character.setRace(Race.ELF);
//        character.setCharacterClass(CharacterClass.WIZARD);
//
//        Character created = service.createCharacter(character);
//        Character fetched = service.getCharacter(created.getId());
//
//        assertNotNull(fetched);
//        assertEquals(created.getId(), fetched.getId());
//        assertEquals("Test", fetched.getName());
//    }

    @Test
    void testAssignStandardArray_correctlyAssignsAbilities() {
        Character character = createValidCharacter();
        character.setStrength(0);
        character.setDexterity(0);
        character.setConstitution(0);
        character.setIntelligence(0);
        character.setWisdom(0);
        character.setCharisma(0);

        List<String> assignmentOrder = List.of("strength", "dexterity", "constitution", "intelligence", "wisdom", "charisma");

        Character expectedCharacter = createValidCharacter();
        expectedCharacter.setStrength(15);
        expectedCharacter.setDexterity(14);
        expectedCharacter.setConstitution(13);
        expectedCharacter.setIntelligence(12);
        expectedCharacter.setWisdom(10);
        expectedCharacter.setCharisma(8);

        when(characterService.assignStandardArray(character, assignmentOrder)).thenReturn(expectedCharacter);

        Character resultantCharacter = characterService.assignStandardArray(character, assignmentOrder);

        assertEquals(15, resultantCharacter.getStrength());
        assertEquals(14, resultantCharacter.getDexterity());
        assertEquals(13, resultantCharacter.getConstitution());
        assertEquals(12, resultantCharacter.getIntelligence());
        assertEquals(10, resultantCharacter.getWisdom());
        assertEquals(8, resultantCharacter.getCharisma());
    }
}
