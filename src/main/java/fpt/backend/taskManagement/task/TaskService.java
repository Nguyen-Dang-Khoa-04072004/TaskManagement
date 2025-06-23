package fpt.backend.taskManagement.task;

import fpt.backend.taskManagement.task.request.AddTaskRequest;
import fpt.backend.taskManagement.task.request.UpdateTaskRequest;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks(String name, List<String> statusList, List<String> priorityList);
    Task getTask(Long id);
    Task createTask(AddTaskRequest request);
    void updateTask(Long id, UpdateTaskRequest request);
    void deleteTask(Long id);
}