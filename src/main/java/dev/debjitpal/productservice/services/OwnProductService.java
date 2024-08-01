package dev.debjitpal.productservice.services;

import dev.debjitpal.productservice.exceptions.ProductNotFoundException;
import dev.debjitpal.productservice.models.Category;
import dev.debjitpal.productservice.models.Product;
import dev.debjitpal.productservice.repositories.CategoryRepository;
import dev.debjitpal.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ownProductService")
public class OwnProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public OwnProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(String title, String description, double price, String category, String image) {
        Product product=new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);

        Category categoryFromDatabase=categoryRepository.findByTitle(category);
        if(categoryFromDatabase==null){
            categoryFromDatabase=new Category();
            categoryFromDatabase.setTitle(category);
          /*  Category newCategory=new Category();
            newCategory.setTitle(category);
            categoryFromDatabase=categoryRepository.save(newCategory); */

//             if we don't use - (cascade = {CascadeType.PERSIST})
        }
        product.setCategory(categoryFromDatabase);
        Product savedProduct=productRepository.save(product);
        return savedProduct;
    }
}
