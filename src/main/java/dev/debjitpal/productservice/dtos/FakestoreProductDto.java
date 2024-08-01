package dev.debjitpal.productservice.dtos;

import dev.debjitpal.productservice.models.Category;
import dev.debjitpal.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakestoreProductDto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

    public Product toProduct(){
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        product.setDescription(description);
        product.setImageUrl(image);

        Category productCategory=new Category();
        productCategory.setTitle(category);
        product.setCategory(productCategory);


        return product;
    }
}