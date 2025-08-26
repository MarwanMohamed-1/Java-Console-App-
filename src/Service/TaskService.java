package Service;

import Model.Task;
import Model.TaskStatus;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskService {
    private List<Task> tasks = new ArrayList<>();
    //Validating
    public static boolean isValidTitle(String title) {
        return title != null && !title.trim().isEmpty();
    }
    public void addTask(Task task) {
        if (!isValidTitle(task.getTitle())) {
            System.out.println("Task title is invalid. Task not added.");
            return;
        }
        tasks.add(task);
        System.out.println("Task added successfully.");
    }
    public List<Task>listTasks()
    {
        if(tasks.isEmpty())
        {
            System.out.println("No tasks available");
        }
        return tasks;
    }
    //Searching
    public List<Task> searchByTitle(String keyword) {
        return tasks.stream()
                .filter(task -> task.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }
    public List<Task> searchByStatus(TaskStatus status) {
        return tasks.stream()
                .filter(task -> task.getStatus() == status)
                .toList();
    }
    //Update Task status
    public boolean updateStatus(int id, TaskStatus newStatus) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setStatus(newStatus);
                return true;
            }
        }
        return false;
    }
    //Delete Task
    public void deleteTask(int id )
    {

        var deletedTask = tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst();

        if (deletedTask.isEmpty()) {
            System.out.println("Task ID not found.");
            return;
        }

        tasks.remove(deletedTask.get());
        System.out.println("Task removed successfully.");

    }
    //Sorting
    public void sortByDueDate() {
        tasks.sort(Comparator.comparing(Task::getDueDate));
    }

    public void sortByPriority() {
        tasks.sort(Comparator.comparing(Task::getPriority));
    }
}
