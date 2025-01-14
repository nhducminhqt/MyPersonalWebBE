package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.extension.serializable.SerializableAutoValue;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ProductDTO {
    @NotBlank(message = "Title is require")
    @Size(min=3,max=200,message = "Title must be between 3 and 200 characters")
    private String name;
    @Min(value = 0, message = "Price must >0")
    @Max(value = 10000000, message = "Price must be < 10.000.000")
    private Float price;
    private String thumbnail;
    private String description;
    @JsonProperty("category_id")
    private String categoryId;
    private List<MultipartFile> files;
}
