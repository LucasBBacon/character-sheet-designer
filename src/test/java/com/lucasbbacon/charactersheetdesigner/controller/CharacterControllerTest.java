package com.lucasbbacon.charactersheetdesigner.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucasbbacon.charactersheetdesigner.model.Character;
import com.lucasbbacon.charactersheetdesigner.service.CharacterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.lucasbbacon.charactersheetdesigner.util.CharacterTestFactory.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    private Character validCharacter;

    @BeforeEach
    void setUp() {
        validCharacter = createValidCharacter();
    }

    @Test
    void testCreateCharacter_validInput_returnsCreatedCharacter() throws Exception {
        mockMvc.perform(post("/characters")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(validCharacter)))
                .andExpect(status().isOk());
    }

    @Test
    void testCreateCharacter_missingName_returnsBadRequest() throws Exception {
        validCharacter.setName("");

        mockMvc.perform(post("/characters")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(validCharacter)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("Name is mandatory"));
    }

    @Test
    void testCreateCharacter_missingRace_returnsBadRequest() throws Exception {
        validCharacter.setRace("");

        mockMvc.perform(post("/characters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(validCharacter)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.race").value("Race is mandatory"));
    }

    @Test
    void testCreateCharacter_missingClass_returnsBadRequest() throws Exception {
        validCharacter.setCharacterClass("");

        mockMvc.perform(post("/characters")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(validCharacter)))
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
}
