package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDTO {
    @JsonProperty("user_id")
    @Min(value = 1,message = "User's id must be >0")
    private String userId;
    @JsonProperty("full_name")
    private String fullName;
    private String address;
    private String email;
    @JsonProperty("phone_number")
    @Size(min=5,message = "Phone number must be at least 5 characters")
    private String phoneNumber;
    private String note;
    @JsonProperty("total_money")
    @Min(value=0, message = "Total's money must be >0")
    private float totalMoney;
    @JsonProperty("shipping_method")
    private String shippingMethod;
    @JsonProperty("shipping_address")
    private String shippingAddress;
    @JsonProperty("payment_method")
    private String paymentMethod;

}
