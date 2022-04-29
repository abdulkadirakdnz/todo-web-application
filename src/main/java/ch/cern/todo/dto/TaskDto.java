package ch.cern.todo.dto;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class TaskDto {

    private Long taskId;
    private String taskName;
    private String taskDescription;
    private Timestamp deadline;
    private TaskCategoryDto taskCategoryDto;

    public TaskDto(Long taskId, String taskName, String taskDescription, Timestamp deadline,
                   TaskCategoryDto taskCategoryDto) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.deadline = deadline;
        this.taskCategoryDto = taskCategoryDto;
    }

    public TaskDto() {
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public TaskCategoryDto getTaskCategoryDto() {
        return taskCategoryDto;
    }

    public void setTaskCategoryDto(TaskCategoryDto taskCategoryDto) {
        this.taskCategoryDto = taskCategoryDto;
    }
}
