package com.productservice.products.repositories;

import com.productservice.products.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByName(String name);

    @Query("SELECT p from Product p where p.price>= :price")   //this is HQL
    List<Product> findByPriceGreaterThanEqual(@Param("price") Float price);

    @Query(value = "SELECT * from Product Where description = ?1", nativeQuery = true)  //this is native query
    List<Product> findByDescription(String description);
}
