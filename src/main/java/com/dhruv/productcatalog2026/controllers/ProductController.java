package com.dhruv.productcatalog2026.controllers;

import com.dhruv.productcatalog2026.models.Product;
import com.dhruv.productcatalog2026.dtos.ProductDTO;
import com.dhruv.productcatalog2026.services.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@RestController 
public class ProductController {
    
    @Autowired 
    private IProductService productService;
    
    @GetMapping ("/products")
    public List<ProductDTO> getAllProducts() {
        // Logic to retrieve all products from the 
        //database
        List<Product> products = productService.getAllProducts();
        // Convert the list of Product entities to a list of ProductDTOs
        List<ProductDTO> productDTOs = products.stream()
                .map(Product::toProductDTO)
                .toList();
        return productDTOs;
    }
    
    @GetMapping ("/products/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product.toProductDTO());
    }
    
    @PutMapping ("/products/{id}")
    public ProductDTO replaceProduct(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO) {
        
        //Convert the ProductDTO to a Product entity
        Product product = productDTO.toProduct();
        
        // Call the service method to replace the product
        Product updatedProduct = productService.replaceProduct(product, id);
        
        // Convert the updated Product entity back to a ProductDTO and return it
        return updatedProduct.toProductDTO();
    }
    
    @PostMapping ("/products")
    public ProductDTO createProduct(@RequestBody Product product) {
        return null;
    }
}
