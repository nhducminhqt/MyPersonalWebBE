package com.example.demo.dtos;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    @NotEmpty(message = "category name can not be empty")
    @Size(min = 3, max = 100, message = "between 3 anh 100 characters")
    private String name;
    private int num;
}
