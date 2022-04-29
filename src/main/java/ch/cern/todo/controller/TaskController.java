package ch.cern.todo.controller;

import ch.cern.todo.dto.CreateTaskRequest;
import ch.cern.todo.dto.TaskDto;
import ch.cern.todo.dto.UpdateTaskRequest;
import ch.cern.todo.entity.TaskEntity;
import ch.cern.todo.service.TaskService;
import ch.cern.todo.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/createTask")
    public ResponseEntity<TaskDto> createTask (@RequestBody CreateTaskRequest taskRequest){
        return ResponseEntity.ok(taskService.createTask(taskRequest));
    }

    @GetMapping("/getAllTask")
    public ResponseEntity<List<TaskDto>> getAllTask (){
        return ResponseEntity.ok(taskService.getAllTask());
    }

    @GetMapping("/getTaskById/{id}")
    public ResponseEntity<TaskDto> getTaskById (@PathVariable Long id){
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/updateTask")
    public ResponseEntity<TaskDto> updateTask(@RequestBody UpdateTaskRequest updateTaskRequest) {
        return ResponseEntity.ok(taskService.updateTask(updateTaskRequest));
    }
}
