package ch.cern.todo.controller;

import ch.cern.todo.dto.*;
import ch.cern.todo.entity.CategoryEntity;
import ch.cern.todo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getCategoryById/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id){
        return  ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @PostMapping("/createCategory")
    public ResponseEntity<TaskCategoryDto> createCategory (@RequestBody CreateCategoryRequest request){
        return ResponseEntity.ok(categoryService.createCategory(request));
    }

    @GetMapping("/getAllCategory")
    public ResponseEntity<List<CategoryDto>> getAllCategory (){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/updateCategory")
    public ResponseEntity<TaskCategoryDto> updateTask(@RequestBody UpdateCategoryRequest updateCategoryRequest) {
        return ResponseEntity.ok(categoryService.updateTask(updateCategoryRequest));
    }
}
