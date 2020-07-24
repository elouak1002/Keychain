package controllers;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

/**
 * @author Abla
 */
public class Home extends Application {


	public void start(Stage stage) {
		
		Parent root = null;
		
		try {
			root = FXMLLoader.load(getClass().getResource("/views/client.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Keychain");
		stage.setResizable(false);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
    }
}
