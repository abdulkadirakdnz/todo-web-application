package ch.cern.todo.service;

import ch.cern.todo.dto.CreateTaskRequest;
import ch.cern.todo.dto.TaskDto;
import ch.cern.todo.dto.TaskDtoConverter;
import ch.cern.todo.dto.UpdateTaskRequest;
import ch.cern.todo.entity.CategoryEntity;
import ch.cern.todo.entity.TaskEntity;
import ch.cern.todo.exception.TaskNotFoundException;
import ch.cern.todo.repository.TaskRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {


    private final TaskDtoConverter converter;
    private final CategoryService categoryService;
    private final TaskRespository taskRespository;

    @Autowired
    public TaskServiceImpl(TaskDtoConverter converter, CategoryService categoryService, TaskRespository taskRespository) {
        this.converter = converter;
        this.categoryService = categoryService;
        this.taskRespository = taskRespository;
    }

    @Override
    public TaskDto createTask(CreateTaskRequest createTaskRequest) {
        CategoryEntity categoryEntity = categoryService.findCategoryById(createTaskRequest.getCategoryId());

        TaskEntity task = new TaskEntity(
                createTaskRequest.getTaskName(),
                createTaskRequest.getTaskDescription(),
                createTaskRequest.getDeadline(),
                categoryEntity);
        return converter.convert(taskRespository.save(task));
    }

    @Override
    public List<TaskDto> getAllTask() {
        return taskRespository.findAll().stream().map(converter::convert).collect(Collectors.toList());
    }

    @Override
    public TaskDto getTaskById(Long id) {
        return converter.convert(findTaskById(id));
    }

    @Override
    public TaskEntity findTaskById(Long id) {
        return taskRespository.findById(id).orElseThrow(
                ()-> new TaskNotFoundException("Task could not find by id:" + id));
    }

    @Override
    public void deleteTask(Long id) {
        taskRespository.deleteById(id);

    }

    @Override
    public TaskDto updateTask(UpdateTaskRequest updateTaskRequest) {
         CategoryEntity categoryEntity = categoryService
                 .findCategoryById(updateTaskRequest.getCategoryId());
        TaskEntity taskEntity = findTaskById(updateTaskRequest.getTaskId());

        taskEntity.setCategoryEntity(categoryEntity);

        Optional.ofNullable(updateTaskRequest.getTaskName()).ifPresent(taskEntity::setTaskName);
        Optional.ofNullable(updateTaskRequest.getTaskDescription()).ifPresent(taskEntity::setTaskDescription);
        Optional.ofNullable(updateTaskRequest.getDeadline()).ifPresent(taskEntity::setDeadline);


        return converter.convert(taskRespository.save(taskEntity));
    }


}
