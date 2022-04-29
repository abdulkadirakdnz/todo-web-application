package ch.cern.todo.dto;

public class UpdateCategoryRequest extends CreateCategoryRequest{

    Long categoryId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
