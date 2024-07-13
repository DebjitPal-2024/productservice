package dev.debjitpal.productservice;

import dev.debjitpal.productservice.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductserviceApplication {

    public static void main(String[] args) {
        Product p = new Product();
        SpringApplication.run(ProductserviceApplication.class, args);
    }

}
