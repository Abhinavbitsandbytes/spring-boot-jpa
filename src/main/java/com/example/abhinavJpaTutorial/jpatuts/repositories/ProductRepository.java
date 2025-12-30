package com.example.abhinavJpaTutorial.jpatuts.repositories;

import com.example.abhinavJpaTutorial.jpatuts.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByTitle(String title);

    @Query("select e from ProductEntity e where e.title=?1 and e.price=?2" )
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);

    // Hibernate:
    //    select
    //        pe1_0.id,
    //        pe1_0.created_at,
    //        pe1_0.price,
    //        pe1_0.quantity,
    //        pe1_0.sku,
    //        pe1_0.title_x,
    //        pe1_0.updated_at
    //    from
    //        product_table pe1_0
    //    where
    //        pe1_0.title_x=?
    //        and pe1_0.price=?

    // we can write custom queries using @Query annotation as shown above
    // here we are writing a JPQL query to fetch ProductEntity by title and price
    // JPQL is similar to SQL but it works with entity objects and their properties instead of tables and columns
    // we can use positional parameters (?1, ?2) or named parameters (:title, :price) in JPQL queries
    // Spring Data JPA will automatically implement this method at runtime
    // and we can use it to fetch products based on title and price
    // we have used "title" and not "title_x" because we are referring to the entity property names, not the database column names
    // which is one of the advantages of using JPQL over native SQL queries
    // we can also use native SQL queries by setting nativeQuery=true in the @Query annotation
    // but it is generally recommended to use JPQL for portability and maintainability

}
