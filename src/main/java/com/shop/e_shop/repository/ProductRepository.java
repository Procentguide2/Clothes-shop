package com.shop.e_shop.repository;

import com.shop.e_shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> getProductsByGender(String gender);
}