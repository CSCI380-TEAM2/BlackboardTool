package database;
import database.databaseMembers;

public class AddNewUserTest {
	public static void main(String[] args){
		databaseMembers loginDB = new databaseMembers();
		//loginDB.insertData("testUser","test@example.com", Integer.toString(("testPassword"+"thisisasaltwhichwillbereplacedlater").hashCode()), "firstName","lastName" );
		//loginDB.insertData("1","1@example.com", Integer.toString(("1"+"thisisasaltwhichwillbereplacedlater").hashCode()), "1","1" );
		loginDB.getInfo("1");
	}
}
