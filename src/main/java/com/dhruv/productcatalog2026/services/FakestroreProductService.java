package com.dhruv.productcatalog2026.services;
import com.dhruv.productcatalog2026.models.Product;
import com.dhruv.productcatalog2026.Clients.FakestoreAPIClient;
import com.dhruv.productcatalog2026.execptions.ProductNotExistException;
import java.util.List;

import org.springframework.http.HttpMethod;

import java.util.ArrayList;
import com.dhruv.productcatalog2026.dtos.FakestoreProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service 
public class FakestroreProductService implements IProductService {
    
    @Autowired 
    private FakestoreAPIClient fakestoreAPIClient;
    
    
    @Override 
    public List<Product> getAllProducts() {
        
        List<Product> products = new ArrayList<>();
        
        FakestoreProductDTO[] fakestoreProductDtos = fakestoreAPIClient.requestForBody(
            HttpMethod.GET,
            "https://fakestoreapi.com/products", 
            null,
            FakestoreProductDTO[].class,
            "Products not found"
        );
        
        for(FakestoreProductDTO fakestoreProductDto : fakestoreProductDtos) {
            products.add(fakestoreProductDto.toProduct());
        }
        return products;
    }
    
    @Override 
    public Product getProductById(Long id) throws ProductNotExistException {
        
        FakestoreProductDTO fakestoreProductDto = fakestoreAPIClient.requestForBody(
            HttpMethod.GET,
            "https://fakestoreapi.com/products/{id}", 
            null,
            FakestoreProductDTO.class,
            "Product not found",
            id
        );
        return fakestoreProductDto.toProduct();
    } 
    
    @Override 
    public Product replaceProduct(Product newProduct, Long id) {
        
        FakestoreProductDTO updatedProduct = fakestoreAPIClient.requestForBody(
            HttpMethod.PUT,
            "https://fakestoreapi.com/products/{id}", 
            newProduct.toFakestoreProductDTO(),
            FakestoreProductDTO.class,
            "Updated product not found",
            id
        );
        return updatedProduct.toProduct();
    }  
    
    @Override 
    public Product createProduct(Product product) {
        return null;
    }

}
