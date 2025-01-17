package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.generator.internal.GeneratedGeneration;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="products")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false,length = 350)
    private String name;
    private String price;
    @Column(name="description")
    private String description;
    @Column(name ="thumbnail")
    private String thumbnail;
    @ManyToOne
    @JoinColumn(name ="category_id")
    private Category category;
}
