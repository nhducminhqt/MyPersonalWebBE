package com.example.demo.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductImageDTO {
    @JsonProperty("product_id")
    @Min(value =1,message = "Product ID >=1")
    private Long productId;
    @Size(min = 2, max = 200,message = "Image's name")
    @JsonProperty("image_url")
    private String imageUrl;
}
