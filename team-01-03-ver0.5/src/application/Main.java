package application;
	
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.List;

import application.personalIndexCardManager.SQLConnector;
import application.personalIndexCardManager.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	// layout parameters
	private static final int LAYOUT_WIDTH	 = 617;
	private static final int LAYOUT_HEIGHT	 = 355;
	private static final String TITLE = "Personal Index Card Manager";
    private static Stage stg;
    
    
    // temporary storage
    //private static List<User> users;
    
    @Override
    public void start(Stage primaryStage) {
        try {
        	stg = primaryStage;
        	primaryStage.setResizable(false);
        	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Home.fxml"));
        	primaryStage.setTitle(TITLE);
        	primaryStage.setScene(new Scene(root, LAYOUT_WIDTH, LAYOUT_HEIGHT));
        	primaryStage.show();
        } catch (Exception e) {
        	e.getStackTrace();
        }
    }
    
    // add user to list
    public void addUser(User user) {
    	SQLConnector con = new SQLConnector();
    	con.addUser("usersTest.db", "Users", user);
    	String fileName = "resources/database/users.txt";
    	try  {
    		FileWriter fw = new FileWriter(fileName, true);
    	    BufferedWriter bw = new BufferedWriter(fw);
    	    bw.write(user.toString());
    	    bw.newLine();
    	    bw.close();
 
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
    
    // go to page "fxml/pageName.fxml"
    public void changeScene(String fxml) {
        Parent pane;
		try {
			
			pane = FXMLLoader.load(getClass().getClassLoader().getResource(fxml));
			stg.getScene().setRoot(pane);
			stg.sizeToScene();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	public static void main(String[] args) {
		launch(args);
	}

	
}
