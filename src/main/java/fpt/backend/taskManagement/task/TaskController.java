package fpt.backend.taskManagement.task;

import fpt.backend.taskManagement.task.reponse.TaskResponse;
import fpt.backend.taskManagement.task.reponse.TasksResponse;
import fpt.backend.taskManagement.task.request.AddTaskRequest;
import fpt.backend.taskManagement.task.request.UpdateTaskRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        @RequestParam(name = "status", required = false) List<String> statusList,
        @RequestParam(name = "priority", required = false) List<String> priorityList
    )
    {
            List<Task> tasks = taskService.getAllTasks(name, statusList, priorityList);
            TasksResponse responseBody = new TasksResponse();
            responseBody.setStatus("Success");
            responseBody.setMessage("Get all tasks successfully");
            responseBody.setTask(tasks);
            return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable Long id){
        Task task = taskService.getTask(id);
        TaskResponse responseBody = new TaskResponse();
        responseBody.setStatus("Success");
        responseBody.setMessage("Get a task successfully");
        responseBody.setTask(task);
        return ResponseEntity.ok(responseBody);
    }
    @PostMapping
    public Task createTask(@RequestBody AddTaskRequest request){
        return taskService.createTask(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @RequestBody UpdateTaskRequest request){
        taskService.updateTask(id,request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable  Long id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
