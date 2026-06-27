// Main Class - Demonstrates the MVC Pattern
public class MVCPatternTest {
    public static void main(String[] args) {
        System.out.println("=== MVC Pattern - Student Records Demo ===\n");

        // Create a Student model with initial data
        Student student = new Student("John Doe", "STU001", "A");

        // Create a View
        StudentView view = new StudentView();

        // Create a Controller, linking the model and the view
        StudentController controller = new StudentController(student, view);

        // Display initial student details
        System.out.println("--- Initial Student Details ---");
        controller.updateView();

        // Update student details using the controller
        System.out.println("\n--- Updating Student Details via Controller ---");
        controller.setStudentName("Jane Smith");
        controller.setStudentId("STU002");
        controller.setStudentGrade("A+");

        // Display updated student details
        System.out.println("\n--- Updated Student Details ---");
        controller.updateView();

        // Another update
        System.out.println("\n--- Updating Grade Only ---");
        controller.setStudentGrade("B+");

        System.out.println("\n--- Final Student Details ---");
        controller.updateView();

        System.out.println("\n=== Demo Complete ===");
    }
}

class Student {
    private String name;
    private String id;
    private String grade;

    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

class StudentView {
    public void displayStudent(String name, String id, String grade) {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + id);
        System.out.println("Student Grade: " + grade);
    }
}

class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentId(String id) {
        model.setId(id);
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    public void updateView() {
        view.displayStudent(model.getName(), model.getId(), model.getGrade());
    }
}
