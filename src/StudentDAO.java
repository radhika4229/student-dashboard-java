import java.sql.*;
public class StudentDAO {
private Connection con;
public StudentDAO() throws SQLException {
    con=DBConnection.getConnection();
}
    public void addStudent(Student student) throws SQLException  {
    String sql="INSERT INTO students(name,roll_no,branch,email,marks) VALUES(?,?,?,?,?)";
    PreparedStatement ps=con.prepareStatement(sql);
    ps.setString(1,student.getName());
    ps.setString(2,student.getRoll_no());
    ps.setString(3,student.getBranch());
    ps.setString(4,student.getEmail());
    ps.setInt(5,student.getMarks());
    ps.executeUpdate();
        System.out.println("Student added successfully");
    }
public void viewStudent(String rollNo) throws SQLException {
String sql="SELECT * FROM students WHERE roll_no=?";
PreparedStatement ps=con.prepareStatement(sql);
ps.setString(1,rollNo);
ResultSet rs=ps.executeQuery();
    if (rs.next()) {
        System.out.println("ID: " + rs.getInt("id"));
        System.out.println("Name: " + rs.getString("name"));
        System.out.println("Roll No: " + rs.getString("roll_no"));
        System.out.println("Branch: " + rs.getString("branch"));
        System.out.println("Email: " + rs.getString("email"));
        System.out.println("Marks: " + rs.getInt("marks"));
    } else {
        System.out.println("❌ No student found with roll number: " + rollNo);
    }
}

public void viewAllstudents() throws SQLException  {
    String sql="SELECT * FROM students";
    PreparedStatement ps=con.prepareStatement(sql);
    ResultSet rs=ps.executeQuery();
    while(rs.next()){
        System.out.println("ID: " + rs.getInt("id"));
        System.out.println("Name: " + rs.getString("name"));
        System.out.println("Roll No: " + rs.getString("roll_no"));
        System.out.println("Branch: " + rs.getString("branch"));
        System.out.println("Email: " + rs.getString("email"));
        System.out.println("Marks: " + rs.getInt("marks"));
    }


}
public void updateStudents(Student student) throws SQLException  {
    String sql="UPDATE  students SET marks=? ,branch=? WHERE roll_no=? ";
    PreparedStatement ps=con.prepareStatement(sql);
    ps.setInt(1,student.getMarks());
    ps.setString(2,student.getBranch());
    ps.setString(3,student.getRoll_no());
   int rowsAffected=ps.executeUpdate();
   if(rowsAffected>0){
       System.out.println("Student updated successfully");
   }
   else{
       System.out.println("<UNK> No student found with roll number: " + student.getRoll_no());
   }
}

public void deleteStudent(String rollNo) throws SQLException  {
    String sql="DELETE FROM students WHERE roll_no=?";
    PreparedStatement ps=con.prepareStatement(sql);
    ps.setString(1,rollNo);
    int rowsAffected=ps.executeUpdate();
    if(rowsAffected>0){
        System.out.println("Student deleted successfully");

    }
    else{
        System.out.println("No student found with roll number: " + rollNo);
    }
}
}
