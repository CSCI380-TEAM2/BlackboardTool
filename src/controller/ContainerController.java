package controller;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;
import java.util.Set;
import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
import javafx.scene.*;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class ContainerController implements Initializable {

	@FXML
	private WebView backgroundAnimate;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		URL url;
		try {
			// add an animation to the header
			File animate = new File("resources/backgroundanimate/index.html");
			backgroundAnimate.getEngine().load(animate.toURI().toURL().toString());
			File headerStyle = new File("resources/backgroundanimate/css/header.css");
			backgroundAnimate.getEngine().setUserStyleSheetLocation(headerStyle.toURI().toURL().toString());
			backgroundAnimate.getEngine().executeScript("window.scrollTo(20,20);");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
