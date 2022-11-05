package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CoursesController {

	@FXML Button accntManageBtn;
	@FXML Button logoutBtn;
	@FXML BorderPane loginScene;

	@FXML public void logout(ActionEvent event) {
		// Changes the scene from one window to another window
		URL url = getClass().getClassLoader().getResource("fxml/Home.fxml");
								
		try {
			// Loads the other scene
			Parent root = FXMLLoader.load(url);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
								
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	/*
	 * Change logout button color when mouse hovers
	 * over the button
	 * 
	 */
	@FXML public void changeLogoutBtnColor() {
		logoutBtn.setStyle("-fx-background-color: #06014a");
		logoutBtn.setTextFill(Color.WHITE);
	}
	
	/*
	 * Reverts logout button color when mouse exits
	 * the button
	 * 
	 */
	@FXML public void revertLogoutBtnColor() {
		logoutBtn.setStyle("-fx-background-color: #F9FEB5");
		logoutBtn.setTextFill(Color.BLACK);
	}

}
