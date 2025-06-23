package fpt.backend.taskManagement.task.request;

import fpt.backend.taskManagement.task.Priority;
import fpt.backend.taskManagement.task.Status;

public class AddTaskRequest {
    private String name;
    private Status status;
    private Priority priority;

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
