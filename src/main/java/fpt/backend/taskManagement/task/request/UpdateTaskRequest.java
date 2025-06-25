package fpt.backend.taskManagement.task.request;

import fpt.backend.taskManagement.task.Priority;

public class UpdateTaskRequest {
    private String name;
    private Boolean isCompleted;
    private Priority priority;

    public String getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
