package com.dhruv.productcatalog2026.execptions;

public class ProductNotExistException extends RuntimeException {
    
    public ProductNotExistException(String message) {
        super(message);
    }

}
