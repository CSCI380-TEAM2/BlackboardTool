package database;

import java.sql.ResultSet;
import java.sql.Statement;

public class colleges {
    ConnectionManager conc = new ConnectionManager();
    public void insertData (String collegeName, String collegeAddress, String collegeCity, String collegeState, int collegeZip, String collegeCountry) {
        try {
        conc.setupConnection();
        Statement stmt = conc.con.createStatement();
        String insert = "INSERT INTO colleges (collegeName, collegeAddress, collegeCity, collegeState, collegeZip, collegeCountry) VALUES ('"+ collegeName +"','"+ collegeAddress +"','"+ collegeCity +"''"+ collegeState +"','"+ collegeZip +"','"+ collegeCountry +"');";
        stmt.executeUpdate(insert);
        System.out.println("Data has been inserted into colleges.");
        conc.con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public void collegesInfo(int departId) {
    	try {
        	conc.setupConnection();
        	Statement stmt=conc.con.createStatement();
        	ResultSet rs=stmt.executeQuery("select collegeID, collegeName, collegeAddress, collegeCity, collegeState, collegeZip, collegeCountry from colleges where deptID = '"+ departId +"';");
        	while(rs.next())
        	System.out.println(rs.getInt(1) +"  "+ rs.getString(2) +"  "+ rs.getInt(3) +" "+ rs.getInt(4) +" "+ rs.getInt(5) +" "+ rs.getInt(6));
        	conc.con.close();
        }
        catch(Exception e) {
        	System.out.println(e);
        }
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
