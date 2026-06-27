// View Class - Responsible for displaying student details
public class StudentView {

    public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
        System.out.println("+-------------------------------------+");
        System.out.println("|        Student Details               |");
        System.out.println("+-------------------------------------+");
        System.out.println("| Name  : " + studentName);
        System.out.println("| ID    : " + studentId);
        System.out.println("| Grade : " + studentGrade);
        System.out.println("+-------------------------------------+");
    }
}
