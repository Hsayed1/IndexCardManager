package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class newpasswordController implements Initializable 
{
	@FXML private PasswordField newPassword;
	@FXML private Button submitBtn;
	
	
	@FXML
	public void resetPasswordOp(ActionEvent event)
	{
		//get password from database and change it to new password
		
		
		//return to home screen
		Stage stage = (Stage)submitBtn.getScene().getWindow();
		stage.close();
		Main m = new Main();
		m.changeScene("fxml/Home.fxml");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
