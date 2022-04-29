package ch.cern.todo.dto;

import ch.cern.todo.entity.TaskEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CategoryTaskDtoConverter  {

    public CategoryTaskDto convert(TaskEntity taskEntity){
        return new CategoryTaskDto(
                Objects.requireNonNull(taskEntity.getTaskId()),
                taskEntity.getTaskName(),
                taskEntity.getTaskDescription(),
                taskEntity.getDeadline()
        );
    }
}
