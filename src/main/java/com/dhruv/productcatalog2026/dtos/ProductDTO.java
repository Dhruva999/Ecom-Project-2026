package com.dhruv.productcatalog2026.dtos;

import com.dhruv.productcatalog2026.models.Category;
import com.dhruv.productcatalog2026.models.Product;
import lombok.Getter;
import lombok.Setter;


/*r
ßepresents the data that will be sent to the client for a product. It is a Data Transfer Object (DTO) that contains the necessary information about a product, such as its name, description, price, image URL, and category. 
This class is used to transfer data between different layers of the application, such as from the service layer to the controller layer, without exposing the internal structure of the Product model.
*/
@Getter 
@Setter 
public class ProductDTO {
    
    private String name;
    private String description;
    private Double price;
    private String imageUrl;
    private CategoryDTO categoryDTO;
    
    public Product toProduct() {
        Product product = new Product();
        product.setName(this.name);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);
        
        if (this.categoryDTO != null) {
            Category category = new Category();
            category.setName(this.categoryDTO.getName());
            category.setDescription(this.categoryDTO.getDescription());
            product.setCategory(category);
        }
        
        return product;
    }

}
