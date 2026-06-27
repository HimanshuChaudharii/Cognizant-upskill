public class TaskLinkedList {

    // Local Task definition to resolve compilation when Task is not declared elsewhere.
    private static class Task {
        private final int taskId;
        private final String taskName;

        @SuppressWarnings("unused")
        Task(int taskId, String taskName) {
            this.taskId = taskId;
            this.taskName = taskName;
        }

        int getTaskId() {
            return taskId;
        }

        String getTaskName() {
            return taskName;
        }

        @Override
        public String toString() {
            return "Task ID: " + taskId + ", Name: " + taskName;
        }
    }
    
    // Node class representing an element in the linked list
    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    /**
     * Adds a task to the end of the linked list.
     * Prevents adding duplicate task IDs.
     */
    public void addTask(Task task) {
        // Check for duplicate task ID
        if (searchTask(task.getTaskId()) != null) {
            System.out.println("Error: Task with ID " + task.getTaskId() + " already exists.");
            return;
        }
        
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Task Added: " + task.getTaskName());
    }

    /**
     * Searches for a task by its unique ID.
     */
    public Task searchTask(int taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getTaskId() == taskId) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    /**
     * Traverses the linked list and displays all tasks.
     */
    public void traverseTasks() {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }
        System.out.println("Task Directory:");
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    /**
     * Deletes a task by its unique ID.
     * Unlinks the target node from the list.
     */
    public boolean deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Error: Task list is empty.");
            return false;
        }

        // If the head node holds the target task
        if (head.task.getTaskId() == taskId) {
            System.out.println("Task Deleted: " + head.task.getTaskName());
            head = head.next; // Move head to the next node
            return true;
        }

        Node prev = head;
        Node curr = head.next;

        // Traverse the list to locate the target node
        while (curr != null) {
            if (curr.task.getTaskId() == taskId) {
                System.out.println("Task Deleted: " + curr.task.getTaskName());
                prev.next = curr.next; // Unlink the node
                return true;
            }
            prev = curr;
            curr = curr.next;
        }

        System.out.println("Error: Task with ID " + taskId + " not found.");
        return false;
    }
}
