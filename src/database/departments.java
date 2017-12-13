package database;

import java.sql.ResultSet;
import java.sql.Statement;

public class departments {
	ConnectionManager conc = new ConnectionManager();
    public void insertData (String deptName, String deptHead, String deptAddress, int collegeID) {
        try {
        	conc.setupConnection();
        	Statement stmt = conc.con.createStatement();
        	String insert = "INSERT INTO departments (deptName, deptHead, deptAddress, collegeID) VALUES ('"+ deptName +"','"+ deptHead +"','"+ deptAddress +"','"+ collegeID +"');";
        	stmt.executeUpdate(insert);
        	System.out.println("Data has been inserted into departments.");
        	conc.con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public void departmentInfo(int courseId) {
    	try {
        	conc.setupConnection();
        	Statement stmt = conc.con.createStatement();
        	ResultSet rs = stmt.executeQuery("select deptName, deptHead, deptAddress from departments where deptID = '"+ courseId +"';");
        	while(rs.next())
        	System.out.println(rs.getString(1) +"  "+ rs.getString(2) +"  "+ rs.getInt(3));
        	conc.con.close();
        }
        catch(Exception e) {
        	System.out.println(e);
        }
    }

    public void deleteDepartment(int departID) {
        try {
        	conc.setupConnection();
        	Statement stmt = conc.con.createStatement();
        	ResultSet rs = stmt.executeQuery("Delete from departments where deptID = '"+ departID +"';");
        	while(rs.next())
        	System.out.println("Successfully deleted department ID = '"+ departID +"'");
        	conc.con.close();
        }
        catch(Exception e) {
        	System.out.println(e);
        }
    }

    public void close() {
        try {
        	System.out.println("Releasing all of the resources.");
        	conc.con.close();
        }
        catch(Exception e) {
        	System.out.println(e);
        }
    }
}
