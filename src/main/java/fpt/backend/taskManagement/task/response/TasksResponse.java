package fpt.backend.taskManagement.task.response;

import fpt.backend.taskManagement.task.Task;

import java.util.List;

public class TasksResponse {
    private int code;
    private String status;
    private String message;
    private List<Task> tasks;

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
