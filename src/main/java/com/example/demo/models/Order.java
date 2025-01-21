package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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
    @Column(name="order_date",length=100)
    private LocalDateTime orderDate;
    @Column(name="status",length=100)
    private String status;
    @Column(name="total_money")
    private Integer totalMoney;
    @Column(name="shipping_address")
    private String shippingAddress;
    @Column(name="shipping_method")
    private String shippingMethod;
    @Column(name="shipping_date")
    private Date shippingDate;
    @Column(name="tracking_number")
    private String trackingNumber;
    @Column(name="payment_method")
    private String paymentMethod;
    @Column(name="active")
    private Boolean active;
}
