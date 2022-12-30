package com.learning.springjpa.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {



//    Optional<Product> findByNameAndPrice(String name, Double price);


//    @Query(value = "select p from Product p p.name=:name and p.price=:price")
//    Optional<Product> findByNameAndPrice(@Param("name") String name, @Param("price") Double price);

}
