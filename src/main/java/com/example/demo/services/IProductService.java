package com.example.demo.services;

import com.example.demo.dtos.ProductDTO;
import com.example.demo.dtos.ProductImageDTO;
import com.example.demo.exceptions.DataNotFoundException;
import com.example.demo.models.Product;
import com.example.demo.models.ProductImage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IProductService {
    public Product createProduct(ProductDTO productDTO) throws DataNotFoundException;
    public Product getProductById(long id) throws Exception;
    Page<Product> getAllProducts(PageRequest pageRequest);
    Product updateProduct(long id, ProductDTO productDTO)throws Exception;
    void deleteProduct(long id);
    boolean existsByName(String name);
    public ProductImage creatProductImage(Long productId
            , ProductImageDTO productImageDTO) throws Exception;
}
