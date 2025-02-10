package com.example.demo.services;

import com.example.demo.dtos.ProductDTO;
import com.example.demo.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Override
    public Product createProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public Product getProductById(long id) {
        return null;
    }

    @Override
    public Page<Product> getAllProducts(PageRequest pageRequest) {
        return null;
    }

    @Override
    public Product updateProduct(long id, ProductDTO productDTO) {
        return null;
    }

    @Override
    public void deleteProduct(long id) {

    }

    @Override
    public boolean existsByName(String name) {
        return false;
    }
}
