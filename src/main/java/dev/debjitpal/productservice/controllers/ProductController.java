package dev.debjitpal.productservice.controllers;

import dev.debjitpal.productservice.models.Product;
import dev.debjitpal.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //POST REQUEST IN POSTMAN
    /* REQUEST BODY
    {
    title:"",
    price:,
    brand:"",
     }*/

    @PostMapping("/products") /* this "PostMapping" annotation will tell spring that whenever
                                    any post request comes to the server with this "/products" endpoint,
                                    call this "createProduct" method
                                 */
    public void createProduct(){

    }
    // get details of a particular product
    //  /products/202
    //  /products/234

    @GetMapping("/products/{id}")  /* with the annotation - "PathVariable", we are telling
                                         spring that in the request of this endpoint there is a
                                         path variable - "id", pass the value of this path
                                         variable -"id" to the parameter - "productId" of the method
                                      */
    public Product getProductDetails(@PathVariable("id") Long productId){
        return productService.getSingleProduct(productId);
    }
    @GetMapping("/products")
    public void getAllProducts(){

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
