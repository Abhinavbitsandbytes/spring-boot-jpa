package com.example.abhinavJpaTutorial.jpatuts.controllers;

import com.example.abhinavJpaTutorial.jpatuts.entities.ProductEntity;
import com.example.abhinavJpaTutorial.jpatuts.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final int PAGE_SIZE = 5;

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //    @GetMapping
//    public List<ProductEntity> getAllProducts2() {
//        return productRepository.findByOrderByPrice();
    // ordering products by price in ascending order
    // but we are restricted upon type of filtering we want
    // if you want to orderby title or any other field, you need to create separate methods in repository
    // to overcome this limitation, we should use sort parameter in query methods
    //
//    }
    @GetMapping
    public Page<ProductEntity> getAllProducts(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "1") Integer pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE);
        return productRepository.findAll(pageable);

//        url = "http://localhost:8080/products?sortBy=price"
                //output
        //{
        //"content": [
        //{
        //"id": 6,
        //"sku": "lays789",
        //"title": "Lays Chips",
        //"price": 25,
        //"quantity": 2,
        //"createdAt": null,
        //"updatedAt": null
        //},
        //{
        //"id": 7,
        //"sku": "kitkat456",
        //"title": "KitKat",
        //"price": 13.7,
        //"quantity": 8,
        //"createdAt": null,
        //"updatedAt": null
        //},
        //{
        //"id": 8,
        //"sku": "sprite111",
        //"title": "Sprite",
        //"price": 29.9,
        //"quantity": 5,
        //"createdAt": null,
        //"updatedAt": null
        //},
        //{
        //"id": 9,
        //"sku": "fanta222",
        //"title": "Fanta",
        //"price": 19.4,
        //"quantity": 7,
        //"createdAt": null,
        //"updatedAt": null
        //},
        //{
        //"id": 10,
        //"sku": "twix333",
        //"title": "Twix",
        //"price": 22.5,
        //"quantity": 9,
        //"createdAt": null,
        //"updatedAt": null
        //}
        //],
        //"empty": false,
        //"first": false,
        //"last": false,
        //"number": 1,
        //"numberOfElements": 5,
        //"pageable": {
        //"offset": 5,
        //"pageNumber": 1,
        //"pageSize": 5,
        //"paged": true,
        //"sort": {
        //"empty": true,
        //"sorted": false,
        //"unsorted": true
        //},
        //"unpaged": false
        //},
        //"size": 5,
        //"sort": {
        //"empty": true,
        //"sorted": false,
        //"unsorted": true
        //},
        //"totalElements": 24,
        //"totalPages": 5
        //}
    }
}

// Inside product controller, we will be accessing product repository methods to perform CRUD operations
// on product entity. Its not a good practice to access repository layer directly from controller layer.
// We should have a service layer in between controller and repository layer to handle business logic.
// But since we already have studied service layer in previous tutorials, we will skip it here for brevity.
