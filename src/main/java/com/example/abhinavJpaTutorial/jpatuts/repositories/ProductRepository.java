package com.example.abhinavJpaTutorial.jpatuts.repositories;

import com.example.abhinavJpaTutorial.jpatuts.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByTitle(String title);
}
