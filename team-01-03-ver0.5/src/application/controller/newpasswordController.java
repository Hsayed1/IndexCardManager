package application.controller;

import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;

public class newpasswordController implements Initializable 
{
	@FXML 
	private PasswordField newPassword;
	
	
	@FXML
	public void resetPasswordOp()
	{
		//get password from database and change it to new password
		//return to home screen
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
