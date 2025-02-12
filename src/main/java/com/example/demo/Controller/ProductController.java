package com.example.demo.Controller;
import com.example.demo.dtos.ProductDTO;
import com.example.demo.dtos.ProductImageDTO;
import com.example.demo.models.Product;
import com.example.demo.models.ProductImage;
import com.example.demo.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService productService;
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
    @PostMapping(value="",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createProducts(
            @Valid @ModelAttribute ProductDTO productDTO,
//            @RequestPart("file") MultipartFile file,
            BindingResult result, MultipartRequest multipartRequest){
       try {
           if(result.hasErrors()){
               List<String> errorMessages = result.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
               return ResponseEntity.badRequest().body(errorMessages);
           }
           Product newProduct = productService.createProduct(productDTO);
           List<MultipartFile> files = productDTO.getFiles();
           files = files == null ? new ArrayList<MultipartFile>(): files;
           for (MultipartFile file: files){
               if(file.getSize()==0){
                   continue;
               }
               if(file != null){
                   if(file.getSize()>10*1024*1024){
                       return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body("this file is too large");
                   }
                   String contentType = file.getContentType();
                   if(contentType == null || !contentType.startsWith("image/")){
                       return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("file must be an image");

                   }
                   String filename = storeFile(file);
                    ProductImage productImage = productService.creatProductImage(newProduct.getId()
                            ,ProductImageDTO.builder().imageUrl(filename).build());
               }
           }


           return ResponseEntity.ok("This is post med"+productDTO);
       }catch (Exception e){
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }
    private String storeFile(MultipartFile file) throws IOException {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
// Thêm UUID vào trước tên file để đảm bảo tên file là duy nhất
        String uniqueFilename = UUID.randomUUID().toString() + "_" + filename;
// Đường dân đến thư mục mà bạn muôn lou file
        java.nio.file.Path uploadDir = Paths.get("uploads");
// Kiểm tra và tạo thư mục nêu nó không tồn tại
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
// Đường dần đây đã đền file
        java.nio.file.Path destination = Paths.get(uploadDir.toString(), uniqueFilename);
// Sao chép file vào thư mục dịch
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        return uniqueFilename;
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


