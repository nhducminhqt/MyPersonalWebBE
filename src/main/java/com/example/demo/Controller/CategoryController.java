package com.example.demo.Controller;
import com.example.demo.dtos.CategoryDTO;
import com.example.demo.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RequiredArgsConstructor
@RestController
//@Validated
@RequestMapping("api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("")
    public ResponseEntity<String> getAllCategories(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ){
        return ResponseEntity.ok("chaobanhaha"+page +limit);
    }

    @PostMapping("")
    public ResponseEntity<?> createCategory(@Valid @RequestBody  CategoryDTO categoryDTO,
                                                   BindingResult result){
        if(result.hasErrors()){
            List<String> errorMessages = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
            return ResponseEntity.badRequest().body(errorMessages);
        }
        categoryService.createCategory(categoryDTO);
        return ResponseEntity.ok("This is post med"+categoryDTO);
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
