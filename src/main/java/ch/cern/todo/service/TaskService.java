package ch.cern.todo.service;

import ch.cern.todo.dto.CreateTaskRequest;
import ch.cern.todo.dto.TaskDto;
import ch.cern.todo.dto.UpdateTaskRequest;
import ch.cern.todo.entity.CategoryEntity;
import ch.cern.todo.entity.TaskEntity;

import java.util.List;

public interface TaskService {

   TaskDto createTask(CreateTaskRequest createTaskRequest);
   List<TaskDto> getAllTask();
   TaskDto getTaskById(Long id);
   TaskEntity findTaskById (Long id);
   void deleteTask(Long id);
   TaskDto updateTask(UpdateTaskRequest updateTaskRequest);
}
