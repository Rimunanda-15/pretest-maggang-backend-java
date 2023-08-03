package com.testFullStack.rimunanda.controller;

import com.testFullStack.rimunanda.dto.CategoriesDto;
import com.testFullStack.rimunanda.entity.Categories;
import com.testFullStack.rimunanda.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Categories>> findAll(){
        List<Categories> categories = this.categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categories> findById(
            @PathVariable(name = "id") Integer id
    ){
        Categories categories = this.categoryService.findById(id);
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<Map<String,Object>> save(
            @RequestBody @Valid CategoriesDto.Save data,
            BindingResult result
    ){
        Map<String,Object> output = new HashMap<>();
        if (result.hasErrors()){
            Map<String,Object> errors = new HashMap<>();
            for (FieldError fieldError : result.getFieldErrors()){
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            output.put("status", errors);
            return ResponseEntity.badRequest().body(output);
        }
        this.categoryService.save(data);
        output.put("status","berhasil menambahkan kategori");
        return ResponseEntity.ok(output);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>> update(
            @PathVariable Integer id,
            @RequestBody CategoriesDto.Update data,
            BindingResult result
    ){
        Map<String,Object> output = new HashMap<>();
        if (result.hasErrors()){
            Map<String,Object> errors = new HashMap<>();
            for (FieldError fieldError: result.getFieldErrors()){
                errors.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            output.put("status",errors);
            return ResponseEntity.badRequest().body(output);
        }
        this.categoryService.update(id, data);
        output.put("status","berhasil mengubah Kategori");
        return ResponseEntity.ok(output);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Integer id
    ){
        this.categoryService.delete(id);
        return ResponseEntity.ok("data berhasil dihapus");

    }
}
