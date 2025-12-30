package com.example.abhinavJpaTutorial.jpatuts.controllers;

import com.example.abhinavJpaTutorial.jpatuts.entities.ProductEntity;
import com.example.abhinavJpaTutorial.jpatuts.repositories.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

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
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy) {
        return productRepository.findBy(Sort.by(sortBy));
    }
}

// Inside product controller, we will be accessing product repository methods to perform CRUD operations
// on product entity. Its not a good practice to access repository layer directly from controller layer.
// We should have a service layer in between controller and repository layer to handle business logic.
// But since we already have studied service layer in previous tutorials, we will skip it here for brevity.
