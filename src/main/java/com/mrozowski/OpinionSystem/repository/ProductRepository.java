package com.mrozowski.OpinionSystem.repository;

import com.mrozowski.OpinionSystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Transactional
    @Query("Update Product p SET p.avg_rating=:average WHERE p.id=:id")
    void updateAverageRating(@Param("id") long id, @Param("average") double average);
}
