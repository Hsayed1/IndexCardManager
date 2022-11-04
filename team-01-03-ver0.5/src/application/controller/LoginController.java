package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
	
	@FXML BorderPane loginScene;
	@FXML Button loginBtn;
	@FXML Button homeBtn;
	@FXML PasswordField passwordField;
	@FXML Label errorLabel;
	@FXML TextField emailField;
	@FXML Label alertEmail;
	@FXML Label alertPass;

	
	@FXML 
	public void userHome(ActionEvent event) {
		
		// Changes the scene from login to home
		URL url = getClass().getClassLoader().getResource("fxml/Home.fxml");
		
		try {
			// Loads the signup scene
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
	 * User logs into the application. Checks to see if all fields have been filled
	 * and are valid in the database. Goes to user's courses page.
	 * 
	 */
	@FXML public void userLogin(ActionEvent event) {
				
		// Checks to see if the email field or password field is empty
		if (emailField.getText().isEmpty() || passwordField.getText().isEmpty()) {
			
			// Displays error message
			errorLabel.setText("***Please make sure all indicated fields have been filled***");
			errorLabel.setVisible(true);
			
			// Sets visibility to true for indicators of fields that need to be filled
			if (emailField.getText().isEmpty()) 
				alertEmail.setVisible(true);						
			if (passwordField.getText().isEmpty()) 
				alertPass.setVisible(true);
			
		}
		else {
			// Get inputs
			String enteredEmail = emailField.getText();
			sop("Email   : " + enteredEmail);
			String enteredPass = passwordField.getText();
			sop("Password: " + enteredPass);
			
			// Check inputs with database
			
			
			// Sets the visibility of the labels to false
			errorLabel.setVisible(false);
			alertEmail.setVisible(false);
			alertPass.setVisible(false);
			
			// Changes the scene from login to user's courses window
			this.changeScene(event, "fxml/success.fxml");
			
		}
	}

	@FXML 
	public void changeHomeBtnColor(MouseEvent event) {
		homeBtn.setStyle("-fx-background-color: lime;");
	}

	@FXML 
	public void revertHomeBtnColor(MouseEvent event) {
		homeBtn.setStyle("-fx-background-color: white;");
	}

	/*
	 * Changes the scene from one scene to another
	 * 
	 */
	private void changeScene(ActionEvent event, String fxml) {
		
		// Changes the scene from one window to another window
		URL url = getClass().getClassLoader().getResource(fxml);
						
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Sets the visibility of the labels to false
		errorLabel.setVisible(false);
		alertEmail.setVisible(false);
		alertPass.setVisible(false);
	}

	private static void sop(Object obj) {
		System.out.println(obj);
	}
}
