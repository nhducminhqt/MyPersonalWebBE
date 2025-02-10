package com.example.demo.services;

import com.example.demo.dtos.ProductDTO;
import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public Product createProduct(ProductDTO productDTO) {
        Category existingCategory = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
    Product newProduct = Product.builder()
            .name(productDTO.getName())
            .price(productDTO.getPrice())
            .thumbnail(productDTO.getThumbnail())
            .category(existingCategory).build();
    return productRepository.save(newProduct);
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
