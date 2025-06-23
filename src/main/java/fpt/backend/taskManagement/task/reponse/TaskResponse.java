package fpt.backend.taskManagement.task.reponse;

import fpt.backend.taskManagement.task.Task;

public class TaskResponse {
    private String status;
    private String message;
    private Task task;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Task getTask() {
        return task;
    }
}
