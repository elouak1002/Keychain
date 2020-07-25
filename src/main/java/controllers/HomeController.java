package controllers;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class HomeController extends Application {

	private Parent root;

	public void start(Stage stage) {
		
		FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("/views/client.fxml"));

		try {
			this.root = homeLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Scene scene = new Scene(this.root);
		stage.setScene(scene);
		stage.setTitle("Keychain");
		stage.setResizable(false);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
    }
}
