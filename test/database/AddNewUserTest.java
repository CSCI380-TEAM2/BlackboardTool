package database;
import database.databaseMembers;

public class AddNewUserTest {
	public static void main(String[] args){
		databaseMembers loginDB = new databaseMembers();
		loginDB.insertData("testUser","test@example.com", Integer.toString(("testPassword"+"thisisasaltwhichwillbereplacedlater").hashCode()), "firstName","lastName" );
	}
}
