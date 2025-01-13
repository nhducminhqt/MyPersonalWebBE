package com.example.demo.Controller;

import com.example.demo.dtos.CategoryDTO;
import com.example.demo.dtos.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    @GetMapping("")
    public ResponseEntity<?> getProduct(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit,
            @Valid @RequestBody ProductDTO productDTO,BindingResult result

    ){
        if(result.hasErrors()){
            List<String> errorMessages = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }
    return  ResponseEntity.ok("getProducts here" +productDTO);
    }
    @PostMapping("")
    public ResponseEntity<?> createProducts(@Valid @RequestBody ProductDTO productDTO,
                                              BindingResult result){
        if(result.hasErrors()){
            List<String> errorMessages = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }
        return ResponseEntity.ok("This is post med"+productDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> getProductById(@PathVariable("id") String productId
    ){
        return  ResponseEntity.ok("getProducts here"+productId);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id
    ){
        return  ResponseEntity.ok("del Products here"+id);
    }
}


