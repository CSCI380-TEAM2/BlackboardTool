package controller;

import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import database.Colleges;
import database.Courses;
import database.Departments;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class DashboardController implements Initializable {
	@FXML
	private WebView backgroundAnimate;
	@FXML
	private Button addNewCourse;
	@FXML
	private Pane TextFieldPane;
	@FXML
	private TextArea courseNameField;
	@FXML
	private TextArea courseDetailField;
	
	
	private String professorID;
	private String professorName;
	private String professorEmail;
	private LinkedList<String[]> courses;
	private LinkedList<String[]> departments;
	private LinkedList<String[]> colleges;
	
	
	public void initData(String professorID, String professorName, String professorEmail) {
		this.professorID = professorID;
		this.professorName = professorName;
		this.professorEmail = professorEmail;
		System.out.println("This method is called!");
		// get courses informations
		Courses coursesDB = new Courses();
		courses = coursesDB.courseInfo(Integer.parseInt(professorID));
		// get departments' informations
		Departments departmentsDB = new Departments();
		departments = new LinkedList<String[]>();
		for(int i = 0; i < courses.size(); i++){
			String[] temp = courses.get(i);
			departments.add(departmentsDB.departmentInfo(Integer.parseInt(temp[2])));
		}
		departmentsDB.close();
		// get colleges' informations
		Colleges collegeDB = new Colleges();
		colleges = new LinkedList<String[]>();
		for(int i = 0; i < courses.size(); i++){
			String[] temp = departments.get(i);
			colleges.add(collegeDB.collegesInfo(Integer.parseInt(temp[3])));
		}
		collegeDB.close();
		// add courses to dashboard interface
		final int LAYOUT_X = 73;
		final int LAYOUT_y = 251;
		final int X_INTERVAL = 254;
		final int Y_INTERVAL = 91;
		final int WIDTH = 209;
		final int HIGHT = 65;
		TextField[] coursesTextFields = new TextField[courses.size()];
		for(int i = 0; i < courses.size(); i++){
			int position_x = 0;
			int position_y = 0;
			position_x = LAYOUT_X + X_INTERVAL*(i%2);
			position_y = LAYOUT_y + Y_INTERVAL*((int)i/2);
			System.out.println(position_x+ "  "+ position_y+ "  "+WIDTH+"  "+HIGHT);
			String[] temp = courses.get(i);
			coursesTextFields[i] = new TextField(temp[0]);
			TextFieldPane.getChildren().add(coursesTextFields[i]);
			coursesTextFields[i].setLayoutX(position_x);
			coursesTextFields[i].setLayoutY(position_y);
			coursesTextFields[i].setPrefWidth(WIDTH);
			coursesTextFields[i].setPrefHeight(HIGHT);
			coursesTextFields[i].setEditable(false);
			coursesTextFields[i].setFont(new Font("Arial", 17));
			coursesTextFields[i].setAlignment(Pos.CENTER);
			coursesTextFields[i].setOnMouseEntered(e -> showCourseInfo(e));
			coursesTextFields[i].setOnMouseClicked(e -> showQuestionPoolFrame(e));
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			// add an animation to the header
			File animate = new File("resources/backgroundanimate/index.html");
			backgroundAnimate.getEngine().load(animate.toURI().toURL().toString());
			File headerStyle = new File("resources/backgroundanimate/css/header.css");
			backgroundAnimate.getEngine().setUserStyleSheetLocation(headerStyle.toURI().toURL().toString());
			backgroundAnimate.getEngine().executeScript("window.scrollTo(20,20);");
			courseDetailField.setEditable(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void showCourseInfo(Event e){
		TextField it = (TextField) e.getSource();
		String courseID = it.getText();
		String[] courseDetails = null;
		int i;
		for(i = 0; i<courses.size(); i++){
			courseDetails = courses.get(i);
			if(courseID.equals(courseDetails[0]))
				break;
		}
		courseNameField.setText(courseDetails[1]);
		ScrollBar scrollBarv = (ScrollBar)courseNameField.lookup(".scroll-bar:vertical");
		if(scrollBarv!=null)
			scrollBarv.setDisable(true);
		String[] departmentDetail = departments.get(i);
		String[] collegeDetail = colleges.get(i);
		String detail = collegeDetail[1]+"\n"+collegeDetail[2]+"\n"+departmentDetail[2]
				+ "\nProf. "+professorName+"\n"+professorEmail+"\n"+courseDetails[0]+"\n"+courseDetails[1];
		courseDetailField.setText(detail);
	}
	
	public void showQuestionPoolFrame(Event e){
		TextField it = (TextField) e.getSource();
		String courseID = it.getText();
		String[] courseDetails = null;
		int i;
		for(i = 0; i<courses.size(); i++){
			courseDetails = courses.get(i);
			if(courseID.equals(courseDetails[0]))
				break;
		}
		
	}
}
