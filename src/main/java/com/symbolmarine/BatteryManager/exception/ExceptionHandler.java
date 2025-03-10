package com.symbolmarine.BatteryManager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(DbConnFailException.class)
    public ResponseEntity<Map<String, Object>> handleDbConnException(DbConnFailException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("code", 500);
        error.put("message", "database connection failed: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
