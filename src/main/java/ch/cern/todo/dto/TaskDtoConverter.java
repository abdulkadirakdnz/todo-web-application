package ch.cern.todo.dto;

import ch.cern.todo.entity.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskDtoConverter {

    private final CategoryDtoConverter categoryDtoConverter;

    public TaskDtoConverter(CategoryDtoConverter categoryDtoConverter) {
        this.categoryDtoConverter = categoryDtoConverter;
    }

    public TaskDto convert(TaskEntity taskEntity){
        return new TaskDto(
                taskEntity.getTaskId(),
                taskEntity.getTaskName(),
                taskEntity.getTaskDescription(),
                taskEntity.getDeadline(),
                categoryDtoConverter.convert(taskEntity.getCategoryEntity())
        );
    }

}
