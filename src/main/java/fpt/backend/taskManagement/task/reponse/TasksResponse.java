package fpt.backend.taskManagement.task.reponse;

import fpt.backend.taskManagement.task.Task;

import java.util.List;

public class TasksResponse {
    private String status;
    private String message;
    private List<Task> task;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<Task> getTask() {
        return task;
    }
}
