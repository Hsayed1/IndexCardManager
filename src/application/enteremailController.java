package application;

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

public class enteremailController implements Initializable
{
	@FXML
	private AnchorPane enterEmailBox;
	@FXML
	private Button submitBtn;
	@FXML
	private TextField email;
	@FXML
	private Label noEmailFoundError;
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
			
			Stage stage = (Stage)submitBtn.getScene().getWindow();
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("securityquestion.fxml"));
			
			primaryStage.setTitle("Security Question");
			primaryStage.setScene(new Scene(root, 600, 400));
			primaryStage.show();
			
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
}