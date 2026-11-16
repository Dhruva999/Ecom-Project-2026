package com.dhruv.productcatalog2026.execptions;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotExistException.class)
    public ResponseEntity<Map<String, String>> handleProductNotFound(
        ProductNotExistException exception
    ) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(Map.of("message", exception.getMessage()));
    }

    @ExceptionHandler(RestClientResponseException.class)
    public ResponseEntity<Map<String, String>> handleExternalApiError(
        RestClientResponseException exception
    ) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
            .body(Map.of("message", "The product service returned an error"));
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<Map<String, String>> handleExternalApiUnavailable(
        ResourceAccessException exception
    ) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
            .body(Map.of("message", "The product service is unavailable"));
    }
}
