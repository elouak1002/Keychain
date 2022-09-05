package controllers;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.util.Locale;

import java.io.IOException;

public class HomeController extends Application {

	private Parent root;

	public void start(Stage stage) {
		Locale.setDefault(Locale.ENGLISH);
		
		FXMLLoader clientLoader = new FXMLLoader(getClass().getResource("/views/client.fxml"));

		try {
			this.root = clientLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Scene scene = new Scene(this.root);
		scene.getStylesheets().add("/views/gui.css");
		stage.setScene(scene);
		stage.setTitle("Archived and Encrypted");
		stage.setResizable(false);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
    }
}
