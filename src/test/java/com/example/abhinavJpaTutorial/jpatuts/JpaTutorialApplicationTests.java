package com.example.abhinavJpaTutorial.jpatuts;

import com.example.abhinavJpaTutorial.jpatuts.entities.ProductEntity;
import com.example.abhinavJpaTutorial.jpatuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository() {
		ProductEntity productEntity = ProductEntity.builder()
				.sku("nestle234")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(123.45))
				.quantity(12)
				.build();

		ProductEntity savedProductEntity = productRepository.save(productEntity);
		System.out.println(savedProductEntity);
	}

	@Test
	void getRepository() {
		List<ProductEntity> entities = productRepository.findByTitle("pepsi");
		System.out.println(entities);
	}

	@Test
	void getSingleFromRepository() {
		Optional<ProductEntity> productEntity = productRepository
				.findByTitleAndPrice("Peps", BigDecimal.valueOf(14.4));
		productEntity.ifPresent(System.out::println);
	}

//	output
//	Hibernate:
//	select
//	pe1_0.id,
//	pe1_0.created_at,
//	pe1_0.price,
//	pe1_0.quantity,
//	pe1_0.sku,
//	pe1_0.title_x,
//	pe1_0.updated_at
//			from
//	product_table pe1_0
//	where
//	pe1_0.title_x=?

	//one cool, feature of Spring Data JPA is Query Derivation: it can derive queries from method names
//	for example, findByTitle above is not an actual method, but Spring Data JPA derives the query from the method name
	//	and implements it at runtime. We can create complex queries just by defining method names in the repository interface.
	// inside repository we have just written List<ProductEntity> findByTitle(String title);
	//	and Spring Data JPA automatically implements it to fetch products based on title.
	// if you create a method with name findByTitles(), it will throw error as it cannot derive query from that name
	// because there is no property named 'titles' in ProductEntity.

	// rules to follow for query derivation:
//	Rules for creating Query Methods - List<Product> findByDateCreatedBetween(Date startDate, Date endDate);
	// 1. Start the method name with a prefix like findBy, readBy, getBy
	// 2. Follow the prefix with the property name of the entity (e.g., Title, Price, Quantity)
	// 3. You can combine multiple properties using And, Or (e.g., findByTitleAndPrice)
	// 4. Use comparison keywords like LessThan, GreaterThan, Like, Between (e.g., findByPriceLessThan)
	// 5. Spring Data JPA will automatically generate the query based on the method name and parameters.



}
