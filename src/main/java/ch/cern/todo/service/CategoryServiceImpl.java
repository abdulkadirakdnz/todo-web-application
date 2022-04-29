package ch.cern.todo.service;

import ch.cern.todo.dto.*;
import ch.cern.todo.entity.CategoryEntity;
import ch.cern.todo.entity.TaskEntity;
import ch.cern.todo.exception.CategoryNotFoundException;
import ch.cern.todo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryDtoConverter converter;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryDtoConverter categoryDtoConverter) {
        this.categoryRepository = categoryRepository;
        this.converter = categoryDtoConverter;
    }

    @Override
    public CategoryEntity findCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                ()-> new CategoryNotFoundException("Category could not find by id:" + id));
    }


    @Override
    public TaskCategoryDto createCategory(CreateCategoryRequest request) {
        CategoryEntity categoryEntity = new CategoryEntity(
                request.getCategoryName(),
                request.getCategoryDescription()
        );
        return converter.convert(categoryRepository.save(categoryEntity));
    }


    @Override
    public CategoryDto getCategoryById(Long id) {
        return converter.convertToCategoryDto(findCategoryById(id));
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        return categoryRepository.findAll().stream()
                .map(converter::convertToCategoryDto).collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public TaskCategoryDto updateTask(UpdateCategoryRequest updateCategoryRequest) {
        CategoryEntity categoryEntity = findCategoryById(updateCategoryRequest.getCategoryId());
        Optional.ofNullable(updateCategoryRequest.getCategoryName()).ifPresent(categoryEntity::setCategoryName);
        Optional.ofNullable(updateCategoryRequest.getCategoryDescription()).ifPresent(categoryEntity::setCategoryDescription);


        return converter.convert(categoryRepository.save(categoryEntity));
    }


}
