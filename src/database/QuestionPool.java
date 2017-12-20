package database;

import java.sql.ResultSet;
import java.sql.Statement;

public class QuestionPool {
	ConnectionManager conc = new ConnectionManager();
    public void insertData (int questionID, String question) {
        try {
    		conc.setupConnection();
        	Statement stmt = conc.con.createStatement();
        	String insert = "INSERT INTO questionPool (questionID, question) VALUES ('"+ questionID +"','"+ question +"');";
        	stmt.executeUpdate(insert);
        	System.out.println("Data has been inserted into questionPool.");
        	conc.con.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public void deleteQuestion(int deleteQuestion) {
        try {
        	conc.setupConnection();
        	Statement stmt=conc.con.createStatement();
        	ResultSet rs=stmt.executeQuery("Delete from questionPool where questionID = '"+ deleteQuestion +"';");
        	while(rs.next())
        	System.out.println("Successfully deleted question ID = '"+ deleteQuestion +"'");
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

    public void questionInfo(String professorID, String courseID) {
    	try {
        	conc.setupConnection();
        	Statement stmt = conc.con.createStatement();
        	ResultSet rs = stmt.executeQuery("select questionID, question from questionPool where instructor = '"+ professorID +"' and courseID = '"+ courseID +"';");
        	while(rs.next())
        	System.out.println(rs.getString(1) +"  "+ rs.getString(2));
        	conc.con.close();
        }
        catch(Exception e) {
        	System.out.println(e);
        }
    }
}
