package dev.debjitpal.productservice.services;

import dev.debjitpal.productservice.exceptions.ProductNotFoundException;
import dev.debjitpal.productservice.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long productId) throws ProductNotFoundException;

    List<Product> getProducts();

    Product createProduct(String title, String description, double price, String category, String image);
}
