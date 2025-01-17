package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="categories")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", nullable=false)
    private String name;

}
