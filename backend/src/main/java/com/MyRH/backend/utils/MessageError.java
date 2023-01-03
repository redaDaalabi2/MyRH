package com.MyRH.backend.utils;

import org.springframework.http.ResponseEntity;

public class MessageError {

    // Method to return response entity in case of error with status code 400
    public static ResponseEntity<?> error(String message) {
        return ResponseEntity.badRequest().body(message);
    }

}
