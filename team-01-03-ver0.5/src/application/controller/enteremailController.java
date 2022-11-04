package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;

public class enteremailController implements Initializable
{
	@FXML private AnchorPane enterEmailBox;
	@FXML private Button submitBtn;
	@FXML private TextField email;
	@FXML private Label noEmailFoundError;
	@FXML private Button backLoginBtn;
	
	
	@FXML
	public void checkEmailOp() throws IOException
	{
		
		boolean notFound = false; //temp variable
		//first check if the email is not saved in the system. We will assume it is for now
		if(notFound == true)
		{
			System.out.println("The email is not associated with an account");
			noEmailFoundError.setVisible(true);
			noEmailFoundError.setText("*There is no account linked to this email*");
			
		}
		else
		{
			noEmailFoundError.setVisible(false);
			
			
			// Creates security question prompt
			Stage stage = (Stage)submitBtn.getScene().getWindow();
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/securityquestion.fxml"));
			
			// Settings for the security question prompt
			primaryStage.setTitle("Security Question");
			primaryStage.setScene(new Scene(root, 500, 300));
			primaryStage.alwaysOnTopProperty();
			primaryStage.centerOnScreen();
			primaryStage.setResizable(false);
			primaryStage.initModality(Modality.APPLICATION_MODAL); // Does not allow the main window from being
																   // from being accessed until the prompt has 
																   // been exited or goes back to main window
			primaryStage.show();
			
		}
	}
	
	@FXML public void goToLogin(ActionEvent event) {
		// Changes the scene from reset password to login scene
		URL url = getClass().getClassLoader().getResource("fxml/Login.fxml");
								
		try {
			// Loads the login screen
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
		// TODO Auto-generated method stub
		
	}
	
}