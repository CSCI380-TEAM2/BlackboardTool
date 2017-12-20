package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import database.databaseMembers;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;


public class LoginController implements Initializable {
	databaseMembers loginDB; 
	 
	@FXML
	private Button loginButton;
	@FXML
	private TextField usernameTextField;
	@FXML
	private TextField passwordTextField;
	@FXML
	private Label loginInfo;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loginDB = new databaseMembers();
		// TODO Read settings from configure file
	}
	
	public void login(ActionEvent event){
		String username = usernameTextField.getText();
		String userid = loginDB.getLogicID(username);
		if(userid==null){
			loginInfo.setText("User does not exist");
			loginInfo.setTextFill(Color.rgb(210, 39, 30));
			return;
		}
		System.out.println("Retrived user id is: " + userid);
		String saltedPassword = Integer.toString((passwordTextField.getText()
				+"thisisasaltwhichwillbereplacedlater").hashCode());
		System.out.println("Salted password is: " + saltedPassword);
		if(loginDB.login(Integer.parseInt(userid), saltedPassword)){
			System.out.println("Login succeed");
			loginInfo.setText("Login succeed");
			loginInfo.setTextFill(Color.rgb(21, 117, 84));
			Stage stage = (Stage) loginButton.getScene().getWindow();
			stage.close();
			try {
				final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/Dashboardb.fxml"));
				String[] info = loginDB.getInfo(userid);
				Parent root;
				root = (Parent) fxmlLoader.load();
				DashboardController controller = 
			    		fxmlLoader.<DashboardController>getController();
			    controller.initData(userid, info[0], info[1]);
				Scene dashboard = new Scene(root);
			    Stage mainStatge = new Stage();
			    mainStatge.setTitle("BlackBoard Tool");
			    mainStatge.setScene(dashboard);
			    mainStatge.show();
			    
			} catch (IOException e) {
				e.printStackTrace();
			}
			loginDB.close();
		      
		}else{
			loginInfo.setText("Invalid password");
			loginInfo.setTextFill(Color.rgb(210, 39, 30));
		}
	}
	
}
