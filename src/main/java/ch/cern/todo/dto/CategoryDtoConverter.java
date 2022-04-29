package ch.cern.todo.dto;

import ch.cern.todo.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoConverter {


    public TaskCategoryDto convert(CategoryEntity categoryEntity) {
        if (categoryEntity == null)
            return new TaskCategoryDto(0L, "", "");
        return new TaskCategoryDto(
                categoryEntity.getCategoryID(),
                categoryEntity.getCategoryName(),
                categoryEntity.getCategoryDescription()
        );
    }

    public CategoryDto convertToCategoryDto(CategoryEntity categoryEntity) {
        return new CategoryDto(
                categoryEntity.getCategoryID(),
                categoryEntity.getCategoryName(),
                categoryEntity.getCategoryDescription());
    }
}
