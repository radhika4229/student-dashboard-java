import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
private static final String URL="jdbc:postgresql://localhost:5432/student_dashboard";
private static final String username="postgres";
private static final String password="newpassword";



   public static Connection getConnection()throws SQLException {


           return DriverManager.getConnection(URL,username,password);


}
}

