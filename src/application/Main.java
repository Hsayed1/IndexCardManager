package application;
	
import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
    private static Stage stg;
    
    // temporary storage
    private static List<User> users;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stg = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        primaryStage.setTitle("Index Cards");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
    
    // add user to list
    public void addUser(User user) {
		users.add(user);
	}
	
    // go to page "pageName.fxml"
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }
    
	public static void main(String[] args) {
		launch(args);
	}

	
}
