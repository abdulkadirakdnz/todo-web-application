package ch.cern.todo.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "TASK_CATEGORIES")
public class CategoryEntity {
    @Id
    @SequenceGenerator(name="seq-gen",sequenceName="CATEGORIES_SEQ_GEN", initialValue=1, allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq-gen")
    @Column(name = "CATEGORY_ID")
    private Long categoryID;
    @Column(name = "CATEGORY_NAME",nullable = false,length = 100,unique = true)
    private String categoryName;
    @Column(name = "CATEGORY_DESCRIPTION",length = 500)
    private String categoryDescription;
    @OneToMany(mappedBy = "categoryEntity",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TaskEntity> taskEntity;

    public CategoryEntity(String categoryName, String categoryDescription) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }
   public CategoryEntity(){}

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public Long getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public Set<TaskEntity> getTaskEntity() {
        return taskEntity;
    }

    public void setTaskEntity(Set<TaskEntity> taskEntity) {
        this.taskEntity = taskEntity;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

}
