package ch.cern.todo.dto;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class CategoryTaskDto {

    private Long taskId;
    private String taskName;
    private String taskDescription;
    private Timestamp deadline;

    public CategoryTaskDto(Long taskId, String taskName, String taskDescription, Timestamp deadline) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.deadline = deadline;
    }

    public CategoryTaskDto() {
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
}
