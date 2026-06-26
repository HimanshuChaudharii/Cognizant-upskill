public class Main {
    public static void main(String[] args) {
        // Initialize management system with a capacity of 5
        EmployeeManagement em = new EmployeeManagement(5);

        System.out.println("=== Adding Employees ===");
        em.addEmployee(new Employee(101, "Alice Smith", "Software Engineer", 85000.0));
        em.addEmployee(new Employee(102, "Bob Jones", "Product Manager", 95000.0));
        em.addEmployee(new Employee(103, "Charlie Brown", "QA Lead", 75000.0));
        em.addEmployee(new Employee(104, "Diana Prince", "Security Analyst", 110000.0));

        // Try adding duplicate ID
        em.addEmployee(new Employee(101, "Duplicate Alice", "Developer", 85000.0));

        System.out.println("\n=== Traversing Employee Records ===");
        em.traverseEmployees();

        System.out.println("\n=== Searching for Employees ===");
        searchAndPrint(em, 102);
        searchAndPrint(em, 105); // Non-existent

        System.out.println("\n=== Deleting Employee ===");
        em.deleteEmployee(103); // Middle element deletion
        em.deleteEmployee(105); // Non-existent deletion

        System.out.println("\n=== Traversing After Deletion ===");
        em.traverseEmployees();

        System.out.println("\n=== Testing Capacity Limit ===");
        // Current size is 3, capacity is 5. Add two more.
        em.addEmployee(new Employee(105, "Ethan Hunt", "Operations Director", 120000.0));
        em.addEmployee(new Employee(106, "Fiona Gallagher", "HR Specialist", 60000.0));
        
        // This should fail as size reaches capacity (5)
        em.addEmployee(new Employee(107, "George Costanza", "Assistant to the General Manager", 45000.0));

        System.out.println("\n=== Final Directory ===");
        em.traverseEmployees();
    }

    private static void searchAndPrint(EmployeeManagement em, int employeeId) {
        System.out.print("Searching for ID " + employeeId + " -> ");
        Employee emp = em.searchEmployee(employeeId);
        if (emp != null) {
            System.out.println("Found: " + emp);
        } else {
            System.out.println("Not Found");
        }
    }
}
