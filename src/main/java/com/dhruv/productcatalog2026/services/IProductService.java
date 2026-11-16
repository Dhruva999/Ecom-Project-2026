package com.dhruv.productcatalog2026.services;
import com.dhruv.productcatalog2026.models.Product;
import java.util.List;


public interface IProductService {
    
    List<Product> getAllProducts();
    
    Product getProductById(Long id);
    
    Product createProduct(Product product);
    
    Product replaceProduct(Product product,Long id);
    

}
