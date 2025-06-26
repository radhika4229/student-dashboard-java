import java.sql.SQLException;
import java.util.Scanner;

public class StudentDashboard {
    private StudentDAO dao;
    private Scanner sc;

    public StudentDashboard() throws SQLException {
        dao = new StudentDAO();
        sc = new Scanner(System.in);
    }

    public void showMenu() throws SQLException {
        while (true) {
            System.out.println("\n📘 STUDENT DASHBOARD MENU");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Student by Roll No");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudentMenu();
                    break;

                case 2:
                    dao.viewAllstudents(); // ✅ fixed name
                    break;

                case 3:
                    System.out.print("Enter Roll No to view: ");
                    String rollToView = sc.nextLine();
                    dao.viewStudent(rollToView);
                    break;

                case 4:
                    updateStudentMenu();
                    break;

                case 5:
                    System.out.print("Enter Roll No to delete: ");
                    String rollToDelete = sc.nextLine();
                    dao.deleteStudent(rollToDelete); // ✅ fixed name
                    break;

                case 6:
                    System.out.println("🚪 Exiting...");
                    return;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }

    private void addStudentMenu() throws SQLException {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll No: ");
        String rollNo = sc.nextLine();

        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();
        sc.nextLine(); // consume newline

        Student student = new Student();
        student.setName(name);
        student.setRoll_no(rollNo);
        student.setBranch(branch);
        student.setEmail(email);
        student.setMarks(marks);

        dao.addStudent(student);
    }

    private void updateStudentMenu() throws SQLException {
        System.out.print("Enter Roll No to update: ");
        String rollNo = sc.nextLine();

        System.out.print("Enter New Branch: ");
        String branch = sc.nextLine();

        System.out.print("Enter New Marks: ");
        int marks = sc.nextInt();
        sc.nextLine();

        Student student = new Student();
        student.setRoll_no(rollNo);
        student.setBranch(branch);
        student.setMarks(marks);

        dao.updateStudents(student);}}
