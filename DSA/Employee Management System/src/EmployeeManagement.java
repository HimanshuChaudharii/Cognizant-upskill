public class EmployeeManagement {
    private Employee[] employees;
    private int size; // Tracks the actual number of employees in the array

    public EmployeeManagement(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    /**
     * Adds an employee to the array.
     * Checks if the array is full or if the ID is a duplicate.
     */
    public boolean addEmployee(Employee employee) {
        if (size >= employees.length) {
            System.out.println("Error: Cannot add employee. Array is full.");
            return false;
        }
        // Check for duplicate employee ID
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employee.getEmployeeId()) {
                System.out.println("Error: Employee with ID " + employee.getEmployeeId() + " already exists.");
                return false;
            }
        }
        employees[size] = employee;
        size++;
        System.out.println("Employee Added: " + employee.getName());
        return true;
    }

    /**
     * Searches for an employee by their unique ID.
     */
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    /**
     * Traverses and prints all active employee records.
     */
    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employee records found.");
            return;
        }
        System.out.println("Employee Directory (" + size + "/" + employees.length + "):");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    /**
     * Deletes an employee by their ID.
     * Shifts subsequent elements to the left to fill the gap and prevent null elements in the middle.
     */
    public boolean deleteEmployee(int employeeId) {
        int indexToDelete = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                indexToDelete = i;
                break;
            }
        }

        if (indexToDelete == -1) {
            System.out.println("Error: Employee with ID " + employeeId + " not found.");
            return false;
        }

        String deletedName = employees[indexToDelete].getName();
        
        // Shift elements to the left to close the gap
        for (int i = indexToDelete; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        
        // Dereference the last element to prevent memory leak
        employees[size - 1] = null;
        size--;
        System.out.println("Employee Deleted: " + deletedName);
        return true;
    }
}
