package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="product_images")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    private String imageUrl;
}
