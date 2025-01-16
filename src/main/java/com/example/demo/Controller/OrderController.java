package com.example.demo.Controller;

import com.example.demo.dtos.OrderDTO;
import jakarta.validation.Valid;
import lombok.*;
import org.checkerframework.checker.units.qual.A;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/orders")
public class OrderController {
    @PostMapping("")
    public ResponseEntity<?> createOrder(@RequestBody @Valid OrderDTO orderDTO,
                                         BindingResult result) {
        try {
            if (result.hasErrors()) {
                List<String> errorMessages = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }
            return ResponseEntity.ok().body(orderDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<?> getOrders(@Valid @PathVariable("user_id") Long userId) {
        try {
            return ResponseEntity.ok("get oke"+ userId);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrders(
            @Valid @PathVariable Long id,
            @Valid @RequestBody OrderDTO  orderDTO
    ){
        return ResponseEntity.ok().body("cap nhat thong tin" + id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrders(
            @Valid @PathVariable Long id,
            @Valid @RequestBody OrderDTO  orderDTO
    ){
        return ResponseEntity.ok().body("delete thong tin" + id);
    }


}
