package database;

import java.sql.ResultSet;
import java.sql.Statement;

public class databaseMembers {
    ConnectionManager conc = new ConnectionManager();
    public void insertData (String username, String email, String Password, String firstName, String lastName) {
        try {
        	conc.setupConnection();
        	Statement stmt = conc.con.createStatement();
        	String insert = "INSERT INTO databaseMembers (username, email, Password, firstName, lastName) VALUES ('"+ username +"','"+ email +"','"+ Password +"','"+ firstName +"','"+ lastName +"');";
        	stmt.executeUpdate(insert);
        	System.out.println("Data has been inserted into databaseMembers.");
        	conc.con.close();
        	}
        catch(Exception e) {
            System.out.println(e);
        }
    }

    String userName;

    public String getLogicID (String username) {
        try {
        	conc.setupConnection();
        	Statement stmt = conc.con.createStatement();
        	ResultSet rs = stmt.executeQuery("select username from databaseMembers where username = '"+ username +"'");
        	while(rs.next())
        	if(rs.getString(1).equalsIgnoreCase(username)) {
            	System.out.println("User exists = "+ rs.getString(1));
            	userName=rs.getString(1);
        	}
        	else {
            	System.out.println("User does not exist.");
            	return null;
        	}
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return userName;
    }

    public boolean login (int loginID, String password) {
        boolean flag = false;
        try {
        	conc.setupConnection();
        	Statement stmt = conc.con.createStatement();
        	ResultSet rs = stmt.executeQuery("select loginID, Password from databaseMembers where loginID = '"+ loginID +"' and Password = '"+ password +"'");
        	while(rs.next())
        	if(rs.getInt(1) == loginID && rs.getString(2).equalsIgnoreCase(password)) {
            	System.out.println("User has logged in.");
            	flag = true;
        	}
        	else {
            	System.out.println("User does not exist.");
            	flag = false;
        	}
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return flag;
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
