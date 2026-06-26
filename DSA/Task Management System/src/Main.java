import java.util.LinkedList;
import java.util.Iterator;

public class Main {
    private static class Task {
        private final int id;
        private final String description;
        private final String status;

        Task(int id, String description, String status) {
            this.id = id;
            this.description = description;
            this.status = status;
        }

        int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Task{id=" + id + ", description='" + description + "', status='" + status + "'}";
        }
    }

    public static void main(String[] args) {
        LinkedList<Task> taskList = new LinkedList<>();

        System.out.println("=== Adding Tasks ===");
        addTask(taskList, new Task(1, "Design database schema", "Completed"));
        addTask(taskList, new Task(2, "Implement REST API endpoints", "In Progress"));
        addTask(taskList, new Task(3, "Write unit tests", "Pending"));
        addTask(taskList, new Task(4, "Configure CI/CD pipeline", "Pending"));

        // Try duplicate ID
        addTask(taskList, new Task(2, "Duplicate Task", "Pending"));

        System.out.println("\n=== Traversing Tasks ===");
        traverseTasks(taskList);

        System.out.println("\n=== Searching Tasks ===");
        searchAndPrint(taskList, 2);
        searchAndPrint(taskList, 5); // Non-existent

        System.out.println("\n=== Deleting Tasks ===");
        deleteTask(taskList, 1); // Delete head node
        deleteTask(taskList, 3); // Delete middle node
        deleteTask(taskList, 5); // Non-existent deletion

        System.out.println("\n=== Traversing Tasks After Deletion ===");
        traverseTasks(taskList);
    }

    private static void addTask(LinkedList<Task> list, Task task) {
        // Prevent duplicate IDs
        if (searchTask(list, task.getId()) != null) {
            System.out.println("Task with ID " + task.getId() + " already exists. Skipping.");
            return;
        }
        list.add(task);
        System.out.println("Added: " + task);
    }

    private static void traverseTasks(LinkedList<Task> list) {
        if (list.isEmpty()) {
            System.out.println("No tasks to display.");
            return;
        }
        for (Task t : list) {
            System.out.println(t);
        }
    }

    private static Task searchTask(LinkedList<Task> list, int taskId) {
        for (Task t : list) {
            if (t.getId() == taskId) return t;
        }
        return null;
    }

    private static void deleteTask(LinkedList<Task> list, int taskId) {
        Iterator<Task> it = list.iterator();
        while (it.hasNext()) {
            Task t = it.next();
            if (t.getId() == taskId) {
                it.remove();
                System.out.println("Deleted Task ID " + taskId);
                return;
            }
        }
        System.out.println("Task ID " + taskId + " not found. Cannot delete.");
    }

    private static void searchAndPrint(LinkedList<Task> list, int taskId) {
        System.out.print("Searching for Task ID " + taskId + " -> ");
        Task task = searchTask(list, taskId);
        if (task != null) {
            System.out.println("Found: " + task);
        } else {
            System.out.println("Not Found");
        }
    }
}
