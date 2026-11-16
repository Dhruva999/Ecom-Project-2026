package com.dhruv.productcatalog2026.models;

import com.dhruv.productcatalog2026.dtos.ProductDTO;
import com.dhruv.productcatalog2026.dtos.CategoryDTO;
import com.dhruv.productcatalog2026.dtos.FakestoreProductDTO;
import lombok.Getter;
import lombok.Setter;


@Getter 
@Setter
public class Product extends BaseModel {
    
    private String name;
    
    private String description;
    
    private Double price;
    
    private String imageUrl;
    
    private Category category;
    
    public ProductDTO toProductDTO(){
        ProductDTO productDto = new ProductDTO();
        productDto.setName(this.name);
        productDto.setDescription(this.description);
        productDto.setPrice(this.price);
        productDto.setImageUrl(this.imageUrl);
        if (this.category != null) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setName(this.category.getName());
            categoryDTO.setDescription(this.category.getDescription());
            productDto.setCategoryDTO(categoryDTO);
        }
        return productDto;
    }
    
    public FakestoreProductDTO toFakestoreProductDTO() {
        FakestoreProductDTO fakestoreProductDTO = new FakestoreProductDTO();
        fakestoreProductDTO.setId(this.getId());
        fakestoreProductDTO.setTitle(this.name);
        fakestoreProductDTO.setDescription(this.description);
        fakestoreProductDTO.setPrice(this.price);
        fakestoreProductDTO.setImage(this.imageUrl);
        if (this.category != null) {
            fakestoreProductDTO.setCategory(this.category.getName());
        }
        return fakestoreProductDTO;
    }

}
