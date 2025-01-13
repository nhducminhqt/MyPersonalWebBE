package com.example.demo.Controller;
import com.example.demo.dtos.CategoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {
    @GetMapping("")
    public ResponseEntity<String> getAllCategories(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ){
        return ResponseEntity.ok("chaobanhaha"+page +limit);
    }
    @PostMapping("")
    public ResponseEntity<String> createCategories(@RequestBody  CategoryDTO categoryDTO){
        return ResponseEntity.ok("This is post med"+categoryDTO.getName());
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
