package controllers;

import javafx.fxml.FXML;

import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import services.PasswordService;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class ClientController {

	@FXML private TextField usernameField;
	@FXML private PasswordField passwordField;
    @FXML private Button connectButton;
	@FXML private Button accountButton;
	@FXML private VBox vRoot;
	@FXML private Button encryptButton;
	@FXML private Button decryptButton;
	@FXML private Label connectionStatus;

	private Stage passwordWindow;
	private Stage accountWindow;

	@FXML
	public void initialize() {
		vRoot.setId("cb");
	}

	@FXML
	public void openPassword() {
		passwordWindow = new Stage();
		passwordWindow.initModality(Modality.APPLICATION_MODAL);
		Parent root = null;
		FXMLLoader passwordLoader = new FXMLLoader(getClass().getResource("/views/password.fxml"));

		try {
			root = passwordLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		PasswordService service = new PasswordService();
		service.addListener(this);

		PasswordController passwordController = passwordLoader.getController();
		passwordController.injectService(service);


		Scene scene = new Scene(root);
		scene.getStylesheets().add("/views/gui.css");
		passwordWindow.setScene(scene);
		passwordWindow.setTitle("Password");
		passwordWindow.setResizable(false);
		passwordWindow.show();

	}

	@FXML
	public void openAccount() {
		accountWindow = new Stage();
		accountWindow.initModality(Modality.APPLICATION_MODAL);
		Parent root = null;
		FXMLLoader passwordLoader = new FXMLLoader(getClass().getResource("/views/account.fxml"));

		try {
			root = passwordLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		PasswordService service = new PasswordService();

		Scene scene = new Scene(root);
		scene.getStylesheets().add("/views/gui.css");
		accountWindow.setScene(scene);
		accountWindow.setTitle("Password");
		accountWindow.setResizable(false);
		accountWindow.show();

	}




	public void listenPassword(boolean passwordTrue) {
		passwordWindow.close();
		if (passwordTrue) {
			connectionStatus.setText("The connection is set up.");
		}
		else {
			connectionStatus.setText("The connection has failed.");
		}
	}

}