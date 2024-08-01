package dev.debjitpal.productservice.services;

import dev.debjitpal.productservice.dtos.FakestoreProductDto;
import dev.debjitpal.productservice.exceptions.ProductNotFoundException;
import dev.debjitpal.productservice.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
//    @Override
//    public Product getSingleProduct(Long productId) {
//        FakestoreProductDto fakestoreProductDto=restTemplate.getForObject(
//                "https://fakestoreapi.com/products/"+productId, FakestoreProductDto.class);
//        return fakestoreProductDto.toProduct();
//    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {

        ResponseEntity<FakestoreProductDto> fakestoreProductResponse=restTemplate.getForEntity(
                "https://fakestoreapi.com/products/"+productId, FakestoreProductDto.class);

        FakestoreProductDto fakestoreProductDto=fakestoreProductResponse.getBody();
        if(fakestoreProductDto==null){
            throw new ProductNotFoundException("Product with following id : "+productId+
                    " does not exist. Please try with other product.");
        }
        return fakestoreProductDto.toProduct();
    }

    @Override
    public List<Product> getProducts() {

        FakestoreProductDto[] fakestoreProducts = restTemplate.getForObject(
                "https://fakestoreapi.com/products", FakestoreProductDto[].class);

        List<Product> products = new ArrayList<>();

        for (FakestoreProductDto fakestoreProduct: fakestoreProducts) {
            products.add(fakestoreProduct.toProduct());
        }
        return products;
    }
    @Override
    public Product createProduct(String title, String description, double price, String category, String image) {
        FakestoreProductDto fakestoreProductDto=new FakestoreProductDto();
        fakestoreProductDto.setTitle(title);
        fakestoreProductDto.setDescription(description);
        fakestoreProductDto.setPrice(price);
        fakestoreProductDto.setCategory(category);
        fakestoreProductDto.setImage(image);

        FakestoreProductDto response=restTemplate.postForObject(
                "https://fakestoreapi.com/products", //make an api call to this url
                fakestoreProductDto, // send this object as request body
                FakestoreProductDto.class // convert the response of JSON format to this DTO format
        );

        return response.toProduct(); // convert the dto to product model
    }
}
