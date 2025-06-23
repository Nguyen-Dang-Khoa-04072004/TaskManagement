package fpt.backend.taskManagement.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(){
        super("Task not found");
    }
}
