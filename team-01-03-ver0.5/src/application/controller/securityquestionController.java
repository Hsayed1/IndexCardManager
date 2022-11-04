package application.controller;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;

public class securityquestionController implements Initializable
{

	
	@FXML
	private Button submitAnswerBtn;
	
	@FXML
	private Label wrongAnswerError;
	
	@FXML public void checkQuestionOp() throws IOException
	{
		//check if answer matches security question. We will assume it does for now
		boolean passed = true;
		if(passed = true)
		{
			wrongAnswerError.setVisible(false);
			Stage stage2 = (Stage)submitAnswerBtn.getScene().getWindow();
			stage2.close();
			Stage primaryStage2 = new Stage();
			Parent root2 = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/newpassword.fxml"));
			
			primaryStage2.setTitle("New password");
			primaryStage2.setScene(new Scene(root2, 600, 400));
			primaryStage2.show();
			
			
		}
		else
		{
			System.out.println("The answer is wrong");
			wrongAnswerError.setVisible(true);
			wrongAnswerError.setText("*Incorrect answer*");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}


}
