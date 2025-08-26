import Model.Priority;
import Model.Task;
import Model.TaskStatus;
import Service.TaskService;

import java.time.LocalDateTime;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskService service = new TaskService();
        while (true)
        {
            System.out.println("\n1. Add Task\n2. List Tasks\n3. Search Tasks\n4. Update Task Status\n5. Delete Task\n6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    LocalDateTime createdAt = LocalDateTime.now();
                    Task task = new Task(title, description,  TaskStatus.TO_DO,createdAt,Priority.P4);
                    service.addTask(task);
                    break;
                case 2:
                    // List tasks
                    for (var t : service.listTasks())
                    {
                        System.out.println(t);
                    }
                    break;
                case 3:
                    // Search tasks
                    String keyword = scanner.nextLine();
                    for (var tt : service.searchByTitle(keyword))
                    {
                        System.out.println(tt);
                    }
                    break;
                case 4:
                    // Update status
                    break;
                case 5:
                    // Delete task
                    System.out.println("Enter task id:");
                    int id = scanner.nextInt();
                    service.deleteTask(id);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    }
        }
        }
    }
