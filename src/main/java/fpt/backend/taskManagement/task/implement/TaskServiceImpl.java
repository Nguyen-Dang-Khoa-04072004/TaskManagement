package fpt.backend.taskManagement.task.implement;

import fpt.backend.taskManagement.exception.TaskNotFoundException;
import fpt.backend.taskManagement.task.*;
import fpt.backend.taskManagement.task.request.AddTaskRequest;
import fpt.backend.taskManagement.task.request.UpdateTaskRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;
    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks(String name, List<String> statusList, List<String> priorityList) {
        Specification<Task> filter =
            TaskSpec.nameLike(name).and(TaskSpec.hasStatus(statusList)).and(TaskSpec.hasPriority(priorityList));
        return taskRepository.findAll(filter);
    }

    @Override
    public Task getTask(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException());
    }

    @Override
    public Task createTask(AddTaskRequest request) {
        return taskRepository.save(
            new Task(request.getName(), request.getStatus(), request.getPriority())
        );
    }

    @Override
    public void updateTask(Long id, UpdateTaskRequest request) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException());
        task.setName(request.getName() == null ? task.getName() : request.getName());
        task.setStatus(request.getStatus()  == null ? task.getStatus() : request.getStatus());
        task.setPriority(request.getPriority()  == null ? task.getPriority() : request.getPriority());
        taskRepository.save(task);
    }


    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
