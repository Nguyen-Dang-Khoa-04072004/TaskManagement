package fpt.backend.taskManagement.task.implement;

import fpt.backend.taskManagement.exception.BadRequestException;
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
    public List<Task> getAllTasks(String name, Boolean isCompleted, List<String> priorityList) {
        Specification<Task> filter =
            TaskSpec.nameLike(name).and(TaskSpec.isCompleted(isCompleted)).and(TaskSpec.hasPriority(priorityList));
        return taskRepository.findAll(filter);
    }

    @Override
    public Task getTask(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException());
    }

    @Override
    public Task createTask(AddTaskRequest request) {
        if(request.getName() == null || request.getName().isEmpty()){
            throw new BadRequestException("Task name must be specified");
        }
        return taskRepository.save(
            new Task(request.getName(), request.getIsCompleted(), request.getPriority())
        );
    }

    @Override
    public Task updateTask(Long id, UpdateTaskRequest request) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException());
        task.setName(request.getName() == null ? task.getName() : request.getName());
        task.setIsCompleted(request.getIsCompleted()  == null ? task.getIsCompleted() : request.getIsCompleted());
        task.setPriority(request.getPriority()  == null ? task.getPriority() : request.getPriority());
        return taskRepository.save(task);
    }


    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
