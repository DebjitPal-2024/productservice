package dev.debjitpal.productservice.services;

import dev.debjitpal.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId);
    List<Product> getProducts();
}
