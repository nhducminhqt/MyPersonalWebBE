package com.example.demo.Controller;

import com.example.demo.dtos.OrderDetailDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/order_details")
public class OrderDetailController {
    @PostMapping
    public ResponseEntity<?> createOrderDetail(
            @Valid @RequestBody OrderDetailDTO orderDetailDTO
            ){
        return ResponseEntity.ok().body("create oke" + orderDetailDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderDetails(
            @Valid @PathVariable Long id
    ) {
        return ResponseEntity.ok().body("get order details ok"+id);
    }
    @GetMapping("/order/{orderId}")
    public ResponseEntity<?> getAllOrderDetails(
            @Valid @PathVariable Long orderId
    ){
        return ResponseEntity.ok().body("get order details ok"+orderId);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrderDetail(
            @Valid @PathVariable("id") Long id,
            @RequestBody OrderDetailDTO orderDetailDTO
    ){
        return ResponseEntity.ok().body("update oke" + id + "new: " + orderDetailDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrderDetail(
            @Valid @PathVariable("id") Long id
    ){
        return ResponseEntity.ok().body("delete oke" + id);
    }
}
