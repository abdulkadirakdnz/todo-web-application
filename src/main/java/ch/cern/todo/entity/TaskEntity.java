package ch.cern.todo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "TASKS")
public class TaskEntity implements Serializable {
    @Id
    @SequenceGenerator(name="seq-gen-task",sequenceName="TASK_SEQ_GEN", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq-gen-task")
    @Column(name = "TASK_ID")
    private Long taskId;
    @Column(name = "TASK_NAME", nullable = false,length = 100)
    private String taskName;
    @Column(name = "TASK_DESCRIPTION", length = 500)
    private String taskDescription;
    @Column(name = "DEADLINE", nullable = false)
    private Timestamp deadline;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private CategoryEntity categoryEntity;

    public TaskEntity(String taskName, String taskDescription, Timestamp deadline, CategoryEntity categoryEntity) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.deadline = deadline;
        this.categoryEntity = categoryEntity;
    }
    public TaskEntity(){}

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

    public CategoryEntity  getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }
}
