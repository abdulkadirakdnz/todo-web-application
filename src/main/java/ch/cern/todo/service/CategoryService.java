package ch.cern.todo.service;

import ch.cern.todo.dto.*;
import ch.cern.todo.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {

    TaskCategoryDto createCategory(CreateCategoryRequest request);
    CategoryEntity findCategoryById (Long id);
    CategoryDto getCategoryById(Long id);
    List<CategoryDto> getAllCategory();
    void deleteCategory(Long id);
    TaskCategoryDto updateTask(UpdateCategoryRequest updateCategoryRequest);


}
