package com.example.demo.services;

import com.example.demo.dtos.ProductDTO;
import com.example.demo.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IProductService {
    public Product createProduct(ProductDTO productDTO);
    public Product getProductById(long id);
    Page<Product> getAllProducts(PageRequest pageRequest);
    Product updateProduct(long id, ProductDTO productDTO);
    void deleteProduct(long id);
    boolean existsByName(String name);
}
