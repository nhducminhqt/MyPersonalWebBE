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
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="full_name", nullable=false)
    private String fullName;
    @Column(name="phone_number",length = 10, nullable=false)
    private String phoneNumber;
    @Column(name="address",length = 200)
    private String address;
    @Column(name="password",length = 200)
    private String password;
    private Boolean active;
    @Column(name="date_of_birth")
    private String dateOfBirth;
    @Column(name="facebook_account_id")
    private int facebookAccountId;
    @Column(name="google_account_id")
    private int googleAccountId;
    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;

}
