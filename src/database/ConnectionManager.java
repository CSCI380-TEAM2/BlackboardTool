package database;
import java.sql.*;

public class ConnectionManager {
    public Connection con;
    public void setupConnection() {
    	try {
        	Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/examGenerator?useSSL=false","root","23333333");
          //The database is = "examGenerator", the username is = "root", the password is next but left blank for now
        }
    catch(Exception e) {
            System.out.println(e);
        }
    }
}
