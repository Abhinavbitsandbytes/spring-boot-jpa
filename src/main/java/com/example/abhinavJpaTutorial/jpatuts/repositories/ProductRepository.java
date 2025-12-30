package com.example.abhinavJpaTutorial.jpatuts.repositories;

import com.example.abhinavJpaTutorial.jpatuts.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
