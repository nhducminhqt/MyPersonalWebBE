package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name="orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @Column(name="full_name",length=100)
    private String fullName;
    @Column(name="email",length=100)
    private String email;
    @Column(name="phone_number",nullable=false,length=11)
    private String phoneNumber;
    @Column(name="address",length=100)
    private String address;
    @Column(name="note",length=100)
    private String note;
    private String status;
    private Integer totalMoney;
    private String shippingAddress;
    private String shippingMethod;
    private Date shippingDate;
    private String trackingNumber;
    private String paymentMethod;
    private Boolean active;
}
