package dev.debjitpal.productservice.dtos;

import dev.debjitpal.productservice.models.Category;
import dev.debjitpal.productservice.models.Product;
import dev.debjitpal.productservice.services.ProductService;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateProductRequestDto implements ProductService {
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;

    @Override
    public Product getSingleProduct(Long productId) {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(String title, String description, double price, String category, String image) {
        return null;
    }
}
