package dev.debjitpal.productservice.controllers;

import dev.debjitpal.productservice.dtos.CreateProductRequestDto;
import dev.debjitpal.productservice.dtos.ErrorDto;
import dev.debjitpal.productservice.exceptions.ProductNotFoundException;
import dev.debjitpal.productservice.models.Product;
import dev.debjitpal.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    private RestTemplate restTemplate;

    public ProductController(@Qualifier("ownProductService") ProductService productService, RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("/products") /* this "PostMapping" annotation will tell spring that whenever
                                    any post request comes to the server with this "/products" endpoint,
                                    call this "createProduct" method
                                 */
    public Product createProduct(@RequestBody CreateProductRequestDto requestDto){
        return productService.createProduct(
                requestDto.getTitle(),
                requestDto.getDescription(),
                requestDto.getPrice(),
                requestDto.getCategory(),
                requestDto.getImage()
        );
    }
    // get details of a particular product
    //  /products/202
    //  /products/234

    @GetMapping("/products/{id}")  /* with the annotation - "PathVariable", we are telling
                                         spring that in the request of this endpoint there is a
                                         path variable - "id", pass the value of this path
                                         variable -"id" to the parameter - "productId" of the method
                                      */
    public Product getProductDetails(@PathVariable("id") Long productId) throws ProductNotFoundException {
        return productService.getSingleProduct(productId);
    }
//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ErrorDto> handleProductNotFoundException(ProductNotFoundException exception){
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setMessage(exception.getMessage());
//        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
//    }
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() throws ProductNotFoundException {

        List<Product> products = productService.getProducts();

        ResponseEntity<List<Product>> response = new ResponseEntity<>(products, HttpStatus.OK);
        return response;
    }
    @PatchMapping("/products/{id}")
    public void updateProductDetails(@PathVariable("id") Long productId){

    }
    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable("id") Long productId){

    }
    @DeleteMapping("/products/{id}")
    public void deleteProductDetails(@PathVariable("id") Long productId){

    }
}
