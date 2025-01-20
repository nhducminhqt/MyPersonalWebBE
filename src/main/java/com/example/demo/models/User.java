package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String password;
    private Boolean active;
    private String dateOfBirth;
    private int facebookAccountId;
    private int googleAccountId;
}
