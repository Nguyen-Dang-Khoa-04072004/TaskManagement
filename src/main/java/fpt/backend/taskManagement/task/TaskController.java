package fpt.backend.taskManagement.task;

import fpt.backend.taskManagement.task.response.TaskResponse;
import fpt.backend.taskManagement.task.response.TasksResponse;
import fpt.backend.taskManagement.task.request.AddTaskRequest;
import fpt.backend.taskManagement.task.request.UpdateTaskRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }
    @GetMapping
    public ResponseEntity<TasksResponse> getAllTask(
        @RequestParam(name = "name", required = false) String name,
        @RequestParam(name = "isCompleted", required = false) Boolean isCompleted,
        @RequestParam(name = "priority", required = false) List<String> priorityList
    )
    {
            List<Task> tasks = taskService.getAllTasks(name, isCompleted, priorityList);
            TasksResponse responseBody = new TasksResponse();
            responseBody.setCode(200);
            responseBody.setStatus("Success");
            responseBody.setMessage("Get all tasks successfully");
            responseBody.setTasks(tasks);
            return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable Long id){
        Task task = taskService.getTask(id);
        TaskResponse responseBody = new TaskResponse();
        responseBody.setCode(200);
        responseBody.setStatus("Success");
        responseBody.setMessage("Get a task successfully!");
        responseBody.setTask(task);
        return ResponseEntity.ok(responseBody);
    }
    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody @Validated  AddTaskRequest request){
        Task task = taskService.createTask(request);
        TaskResponse responseBody = new TaskResponse();
        responseBody.setCode(201);
        responseBody.setStatus("Success");
        responseBody.setMessage("Create a new task successfully!");
        responseBody.setTask(task);
        return ResponseEntity.created(URI.create("http://localhost:8080/api/tasks/" + task.getId())).body(responseBody);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody UpdateTaskRequest request){
        Task task = taskService.updateTask(id,request);
        TaskResponse responseBody = new TaskResponse();
        responseBody.setCode(200);
        responseBody.setStatus("Success");
        responseBody.setMessage("Update a task successfully!");
        responseBody.setTask(task);
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable  Long id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
