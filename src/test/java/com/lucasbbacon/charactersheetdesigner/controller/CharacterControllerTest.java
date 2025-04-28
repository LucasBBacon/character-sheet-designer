package com.lucasbbacon.charactersheetdesigner.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucasbbacon.charactersheetdesigner.exception.CharacterNotFoundException;
import com.lucasbbacon.charactersheetdesigner.model.Character;
import com.lucasbbacon.charactersheetdesigner.service.CharacterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.lucasbbacon.charactersheetdesigner.util.CharacterTestFactory.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CharacterController.class)
public class CharacterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CharacterService characterService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateCharacter_validInput_returnsCreatedCharacter() throws Exception {
        mockMvc.perform(post("/characters")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(createValidCharacter())))
                .andExpect(status().isOk());
    }

    @Test
    void testCreateCharacter_missingName_returnsBadRequest() throws Exception {
        mockMvc.perform(post("/characters")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(createCharacterWithInvalidName())))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("Name is mandatory"));
    }

    @Test
    void testCreateCharacter_missingRace_returnsBadRequest() throws Exception {
        mockMvc.perform(post("/characters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createCharacterWithInvalidRace())))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.race").value("Race is mandatory"));
    }

    @Test
    void testCreateCharacter_missingClass_returnsBadRequest() throws Exception {
        mockMvc.perform(post("/characters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createCharacterWithInvalidClass())))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.characterClass").value("Class is mandatory"));
    }

    @Test
    void testCreateCharacter_invalidStrength_returnsBadRequest() throws Exception {
        mockMvc.perform(post("/characters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createCharacterWithInvalidStrength())))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.strength").value("Strength must be at most 20"));
    }

    @Test
    void testCreateCharacter_invalidDexterity_returnsBadRequest() throws Exception {
        mockMvc.perform(post("/characters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createCharacterWithInvalidDexterity())))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.dexterity").value("Dexterity must be at least 1"));
    }

    @Test
    void testCreateCharacter_missingBackground_returnsBadRequest() throws Exception {
        mockMvc.perform(post("/characters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createCharacterWithMissingBackground())))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.background").value("Background is mandatory"));
    }

    @Test
    void testCreateCharacter_missingAlignment_returnsBadRequest() throws Exception {
        mockMvc.perform(post("/characters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createCharacterWithMissingAlignment())))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.alignment").value("Alignment is mandatory"));
    }

    @Test
    void testGetAllRaces_returnsListOfRaces() throws Exception {
        mockMvc.perform(get("/characters/races"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0]").value("HUMAN"));
    }

    @Test
    void testGetAllClasses_returnsListOfClasses() throws Exception {
        mockMvc.perform(get("/characters/classes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0]").value("BARBARIAN"));
    }

    @Test
    void testGetAllCharacters_returnsListOfCharacters() throws Exception {
        List<Character> characters = List.of(createValidCharacter());
        when(characterService.getAllCharacters()).thenReturn(characters);

        mockMvc.perform(get("/characters"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].name").value("Test"));
    }

    @Test
    void testUpdateCharacter_validInput_returnsUpdatedCharacter() throws Exception {
        Character updatedCharacter = createValidCharacter();
        updatedCharacter.setName("Updated Name");

        when(characterService.updateCharacter(1L, updatedCharacter)).thenReturn(updatedCharacter);

        mockMvc.perform(put("/characters/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedCharacter)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Name"));
    }

    @Test
    void testDeleteCharacter_successful() throws Exception {
        doNothing().when(characterService).deleteCharacter(1L);

        mockMvc.perform(delete("/characters/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetCharacter_notFound_returns404() throws Exception {
        when(characterService.getCharacter(999L)).thenThrow(new CharacterNotFoundException(999L));

        mockMvc.perform(get("/characters/999"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("Character with ID 999 not found"));
    }
}
