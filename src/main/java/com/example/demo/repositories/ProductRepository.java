package com.example.demo.repositories;

import com.example.demo.models.Product;
import com.google.api.gax.paging.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface ProductRepository extends JpaRepository<Product, Long> {
 boolean existsByName(String name);
 Page<Product> findAll(Pageable pageable);
}
