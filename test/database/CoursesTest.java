package database;

public class CoursesTest {
	public static void main(String[] args){
		Courses coursesdb = new Courses();
		//coursesdb.insertData("CSCI-380", "Computer Organization and Design", 1, 1);
		//coursesdb.insertData("CSCI-854", "Computer Networks", 1, 1);
		coursesdb.courseInfo(1);
	}
}
