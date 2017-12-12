package examGenerator;

import java.sql.ResultSet;
import java.sql.Statement;

public class courses {
	ConnectionManager conc = new ConnectionManager();
    public void insertData (int courseID, String courseName, int deptmentID, String courseSection, int instructor) {

        try {
        	conc.setupConnection();
        	Statement stmt = conc.con.createStatement();
        	String insert = "INSERT INTO courses (courseID, courseName, deptmentID, courseSection, instructor) VALUES ('"+ courseID +"','"+ courseName +"','"+ deptmentID +"','"+ courseSection +"','"+ instructor +"');";
        	stmt.executeUpdate(insert);
        	System.out.println("Data has been inserted into courses.");
        	conc.con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public void courseInfo(int instructorId) {
        try {
        	conc.setupConnection();
        	Statement stmt = conc.con.createStatement();
        	ResultSet rs = stmt.executeQuery("select courseID, courseName, departmentID from courses where instructor = '"+ instructorId +"';");
        	while(rs.next())
        	System.out.println(rs.getInt(1) +"  "+ rs.getString(2) +"  "+ rs.getInt(3));
        	conc.con.close();
        }
        catch(Exception e) {
        	System.out.println(e);
        }
    }

    public void courseDelete(int courseID)
    {
        try {
        	conc.setupConnection();
        	Statement stmt = conc.con.createStatement();
        	ResultSet rs = stmt.executeQuery("Delete from courses where courseID = '"+ courseID +"';");
        	while(rs.next())
        	System.out.println("Successfully deleted course ID = '"+ courseID +"'");
        	conc.con.close();
        }
        catch(Exception e) {
        	System.out.println(e);
        }
    }

    public void close() {
        try {
        	System.out.println("Release all of the resources.");
        	conc.con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
