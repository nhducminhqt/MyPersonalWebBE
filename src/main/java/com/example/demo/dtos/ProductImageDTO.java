package com.example.demo.dtos;

import com.example.demo.models.Product;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ProductImageDTO {
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    @Column(name = "image_url",length=300)
    private String imageUrl;
}
