package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetailDTO {
    @JsonProperty("order_id")
    @Min(value = 1,message = "Order id must be > 0")
    private Long orderId;
    @JsonProperty("product_id")
    @Min(value = 1,message = "Product id must be > 0")
    private String productId;
    @Min(value = 0,message = "Price must be > 0")
    private float price;
    @JsonProperty("number_of_products")
    @Min(value = 1,message = "number_of_products must be > 0")
    private int numberOfProducts;
    @Min(value = 0,message = "Total money must be > 0")
    @JsonProperty("total_money")
    private float totalMoney;
    private String color;
}
