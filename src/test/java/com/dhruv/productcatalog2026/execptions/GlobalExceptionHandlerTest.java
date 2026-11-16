package com.dhruv.productcatalog2026.execptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class GlobalExceptionHandlerTest {

    @Test
    void productNotFoundReturnsNotFoundStatusAndMessage() {
        GlobalExceptionHandler handler = new GlobalExceptionHandler();

        ResponseEntity<java.util.Map<String, String>> response =
            handler.handleProductNotFound(new ProductNotExistException("Product not found"));

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Product not found", response.getBody().get("message"));
    }
}
