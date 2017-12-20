package database;

import java.sql.ResultSet;
import java.sql.Statement;

public class Departments {
	ConnectionManager conc = new ConnectionManager();
    public void insertData (String deptName, int collegeID, String schoolName) {
        try {
        	conc.setupConnection();
        	Statement stmt = conc.con.createStatement();
        	String insert = "INSERT INTO departments (deptName, schoolName, collegeID) VALUES ('"+ deptName +"','"+ schoolName +"','"+ collegeID +"');";
        	stmt.executeUpdate(insert);
        	System.out.println("Data has been inserted into departments.");
        	conc.con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public String[] departmentInfo(int deptId) {
    	String[] result = new String[4];
    	try {
        	conc.setupConnection();
        	Statement stmt = conc.con.createStatement();
        	ResultSet rs = stmt.executeQuery("select deptName, schoolName, collegeID from departments where deptID = '"+ deptId +"';");
        	while(rs.next()){
        		System.out.println(rs.getString(1) +"  "+ rs.getString(2) +"  "+ rs.getString(3));
        		result[0] = deptId+"";
        		result[1] = rs.getString(1);
        		result[2] = rs.getString(2);
        		result[3] = rs.getString(3);
        	}
        	conc.con.close();
        	return result;
        }
        catch(Exception e) {
        	System.out.println(e);
        }
    	return null;
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
