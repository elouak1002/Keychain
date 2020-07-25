package controllers;

import javafx.fxml.FXML;

import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import java.io.IOException;

public class Client {

	@FXML private TextField usernameField;
	@FXML private PasswordField passwordField;
    @FXML private Button connectButton;
	@FXML private ListView<String> filesList = new ListView<>();
    @FXML private TextArea fileArea;
    @FXML private Label fileName;
	@FXML private Label fileStatus;
	@FXML private Label connectionStatus;

	@FXML
	public void initialize() {
	}

	@FXML
	public void openPassword() {
		Stage newWindow = new Stage();
		newWindow.initModality(Modality.APPLICATION_MODAL);
		Parent root = null;

		try {
			root = FXMLLoader.load(getClass().getResource("/views/password.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}


		Scene scene = new Scene(root);
		newWindow.setScene(scene);
		newWindow.setTitle("Password");
		newWindow.setResizable(false);
		newWindow.show();

	}

}