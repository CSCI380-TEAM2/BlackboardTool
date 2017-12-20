package database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class Courses {
	ConnectionManager conc = new ConnectionManager();
    public void insertData (String courseID, String courseName, int deptmentID, int instructor) {

        try {
        	conc.setupConnection();
        	Statement stmt = conc.con.createStatement();
        	String insert = "INSERT INTO courses (courseID, courseName, departmentID, instructor) VALUES ('"+ courseID +"','"+ courseName +"','"+ deptmentID +"','"+ instructor +"');";
        	stmt.executeUpdate(insert);
        	System.out.println("Data has been inserted into courses.");
        	conc.con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public LinkedList courseInfo(int instructorId) {
    	LinkedList<String[]> result = new LinkedList<String[]>();
    	try {
        	conc.setupConnection();
        	Statement stmt = conc.con.createStatement();
        	ResultSet rs = stmt.executeQuery("select courseID, courseName, departmentID from courses where instructor = '"+ instructorId +"';");
        	while(rs.next()){
        		System.out.println(rs.getString(1) +"  "+ rs.getString(2) +"  "+ rs.getString(3));
        		String[] temp = {rs.getString(1),rs.getString(2),rs.getString(3)};
        		result.add(temp);
        	}
        	conc.con.close();
        	return result;
        }
        catch(Exception e) {
        	System.out.println(e);
        }
        return null;
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
