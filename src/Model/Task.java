package Model;

import java.time.LocalDateTime;

public class Task {
    private static int idCounter = 1;
    private int id;
    private String title;
    private String description;
    public TaskStatus status;
    private LocalDateTime dueDate;
    private Priority priority;

    public Task(String title, String description, TaskStatus status, LocalDateTime dueDate, Priority priority) {
        this.id = idCounter++;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Task title:"+this.title+"\n"+
                "Task Description:"+this.description+"\n"+
                "Task Status:"+this.status+"\n"+
                "Task Priority:"+this.priority+"\n"+
                "Task Due Date:"+this.dueDate+"\n";
    }
}
