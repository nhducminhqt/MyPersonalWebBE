package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
    @GetMapping("")
    public ResponseEntity<String> getAllCategories(){
        return ResponseEntity.ok("chaobanhaha");
    }
    @PostMapping("")
    public ResponseEntity<String> createCategories(){
        return ResponseEntity.ok("This is post med");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategories(@PathVariable Long id){
        return ResponseEntity.ok("this is categories:"+id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategories(@PathVariable Long id){
        return ResponseEntity.ok("this is delete categories:"+id);
    }
}
