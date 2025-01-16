package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDetailDTO {
    @JsonProperty("order_id")
    private Long orderId;
    @JsonProperty("product_id")
    private String productId;
    private float price;
    @JsonProperty("number_of_products")
    private int numberOfProducts;
    @JsonProperty("total_money")
    private float totalMoney;
    private String color;
}
