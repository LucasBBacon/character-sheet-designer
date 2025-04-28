package com.lucasbbacon.charactersheetdesigner.exception;

import com.lucasbbacon.charactersheetdesigner.model.CharacterClass;
import com.lucasbbacon.charactersheetdesigner.model.Race;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.put(error.getField(), error.getDefaultMessage())
                );

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleInvalidEnum(HttpMessageNotReadableException ex) {
        String message = ex.getMessage();

        Map<String, String> errors = new HashMap<>();

        if (message.contains("Race")) {
           errors.put("error", "Invalid value for Race. Allowed values are: " + getAllowedRaceValues());
        } else if (message.contains("CharacterClass")) {
            errors.put("error", "Invalid value for CharacterClass. Allowed values are: " + getAllowedClassValues());
        } else {
            errors.put("error", "Malformed request");
        }

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    private String getAllowedRaceValues() {
        return "[" +
                Arrays.stream(Race.values())
                .map(Enum::name)
                .collect(Collectors.joining(", "))
                + "]";
    }

    private String getAllowedClassValues() {
        return "[" +
                Arrays.stream(CharacterClass.values())
                .map(Enum::name)
                .collect(Collectors.joining(", "))
                + "]";
    }
}
