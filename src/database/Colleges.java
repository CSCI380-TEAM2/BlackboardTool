package database;

import java.sql.ResultSet;
import java.sql.Statement;

public class Colleges {
    ConnectionManager conc = new ConnectionManager();
    public void insertData (String collegeName, String collegeAddress) {
        try {
        conc.setupConnection();
        Statement stmt = conc.con.createStatement();
        String insert = "INSERT INTO colleges (collegeName, collegeAddress) VALUES ('"+ collegeName +"','"+ collegeAddress +"');";
        stmt.executeUpdate(insert);
        System.out.println("Data has been inserted into colleges.");
        conc.con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public String[] collegesInfo(int departId) {
    	String[] result = new String[3];
    	try {
        	conc.setupConnection();
        	Statement stmt=conc.con.createStatement();
        	//System.out.println("select collegeID, collegeName, collegeAddress from colleges where collegeID = "+ Integer.toString(departId) +";");
        	ResultSet rs=stmt.executeQuery("select collegeID, collegeName, collegeAddress from colleges WHERE collegeID = "+ departId +";");
        	while(rs.next()){
        		System.out.println(rs.getInt(1) +"  "+ rs.getString(2) +"  "+ rs.getString(3));
        		result[0] = rs.getInt(1)+"";
        		result[1] = rs.getString(2);
        		result[2] = rs.getString(3);
        	}
        	conc.con.close();
        	return result;
        }
        catch(Exception e) {
        	System.out.println(e);
        }
    	return null;
    }

    public void deleteCollege(int collegeID) {
        try {
        	conc.setupConnection();
        	Statement stmt = conc.con.createStatement();
        	ResultSet rs = stmt.executeQuery("Delete from colleges where collegeID = '"+ collegeID +"';");
        	while(rs.next())
        	System.out.println("Successfully deleted college ID = '"+ collegeID +"'");
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
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
