package fpt.backend.taskManagement.task;

import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private Boolean isCompleted;
    @Enumerated(EnumType.STRING)
    private Priority priority;

    private Task(){};

    public Task(String name, Boolean isCompleted, Priority priority) {
        this.name = name;
        this.isCompleted = isCompleted;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

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
