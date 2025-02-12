package com.example.demo.services;

import com.example.demo.dtos.ProductDTO;
import com.example.demo.exceptions.DataNotFoundException;
import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.models.ProductImage;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public Product createProduct(ProductDTO productDTO) throws DataNotFoundException{
        Category existingCategory = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new DataNotFoundException("Category not found"));
    Product newProduct = Product.builder()
            .name(productDTO.getName())
            .price(productDTO.getPrice())
            .thumbnail(productDTO.getThumbnail())
            .category(existingCategory).build();
    return productRepository.save(newProduct);
    }

    @Override
    public Product getProductById(long id) throws Exception{
        return productRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Product not found"));
    }

    @Override
    public Page<Product> getAllProducts(PageRequest pageRequest) {
        return productRepository.findAll(pageRequest);
    }

    @Override
    public Product updateProduct(long id, ProductDTO productDTO)throws Exception {
        Product existingProduct = getProductById(id);
        if (existingProduct != null) {
            Category existingCategory = categoryRepository.findById(id).orElseThrow(()-> new DataNotFoundException("Category not found"));
            existingProduct.setName(productDTO.getName());
            existingProduct.setPrice(productDTO.getPrice());
            existingProduct.setThumbnail(productDTO.getThumbnail());
            existingProduct.setCategory(existingCategory);
            existingProduct.setDescription(productDTO.getDescription());
            return productRepository.save(existingProduct);
        }
        return null;

    }

    @Override
    public void deleteProduct(long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        productOptional.ifPresent(productRepository::delete);
    }

    @Override
    public boolean existsByName(String name) {
        return productRepository.existsByName(name);
    }
    public ProductImage creatProductImage(Long productId, ProductImageDTO productImageDTO) {}
}
