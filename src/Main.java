import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        try {
            StudentDashboard dashboard = new StudentDashboard();
            dashboard.showMenu();
        } catch (SQLException e) {
            System.out.println("❌ Database Error: " + e.getMessage());
        }
    }
}
