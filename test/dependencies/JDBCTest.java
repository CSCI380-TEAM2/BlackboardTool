package dependencies;

public class JDBCTest {
	public static void main(String[] args) {
		 try {
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            System.out.println("JDBC driver loaded");
	        } catch (ClassNotFoundException e) {
	            System.out.println("You haven't installed JDBC driver");
	        } catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
