package controllers;

import javafx.fxml.FXML;

import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import services.ZipService;
import services.AESService;

import java.io.File;
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
	public void processEncryption() {
		Window stage = encryptButton.getScene().getWindow();

		DirectoryChooser directoryChooser = new DirectoryChooser();

		File selectedDirectory = directoryChooser.showDialog(stage);
		if (selectedDirectory == null) {
			return ;
		}

		String password = passwordDialog();
		if (password.length() < 8) {

			Alert alert = createErrorAlert("Please enter an 8-digit password next time.");
			alert.showAndWait();
			connectionStatus.setText("Encryption failed");

			return ;
		}

		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		fileChooser.setInitialFileName(selectedDirectory.getName() +".enc");
		File file = fileChooser.showSaveDialog(stage);

		if (file == null) {
			return ;
		}

		try {
			File newName = null;
			if (!selectedDirectory.getAbsolutePath().contains(".zip")) {
				newName = new File(selectedDirectory.getAbsolutePath() + ".zip");
				selectedDirectory.renameTo(newName);
			} else {
				newName = selectedDirectory;
			}
			ZipService.zipDirectory(newName.getAbsolutePath());
			AESService.encryptFile(newName.getAbsolutePath(),file.getAbsolutePath(),password);
			newName.delete();

			connectionStatus.setText("Encryption succeed");

		} catch (Exception e) {
			Alert alert = createErrorAlert("An error occurred, please retry.");
			alert.showAndWait();
			connectionStatus.setText("Encryption failed");
		}

	}

	@FXML
	public void processDecryption() {
		Window stage = decryptButton.getScene().getWindow();

		FileChooser fileChooser = new FileChooser();

		File selectedFile = fileChooser.showOpenDialog(stage);
		if (selectedFile == null) {
			return ;
		}

		String password = passwordDialog();
		if (password.length() < 8) {

			Alert alert = createErrorAlert("Please enter an 8-digit password next time.");
			alert.showAndWait();
			connectionStatus.setText("Decryption failed");
			return ;
		}


		DirectoryChooser directoryChooser = new DirectoryChooser();
		File directoryName = directoryChooser.showDialog(stage);


		try {
			AESService.decryptFile(selectedFile.getAbsolutePath(),directoryName.getAbsolutePath()+".zip",password);
			selectedFile.delete();
			ZipService.unzipFile(directoryName.getAbsolutePath()+".zip",directoryName.getAbsolutePath());
			connectionStatus.setText("Decryption succeed");

		} catch (Exception e) {
			Alert alert = createErrorAlert("An error occurred, please retry.");
			alert.showAndWait();
			connectionStatus.setText("Encryption failed");
		}

	}

	public String passwordDialog() {
		Stage passwordWindow = new Stage();
		passwordWindow.initModality(Modality.APPLICATION_MODAL);
		Parent root = null;
		FXMLLoader passwordLoader = new FXMLLoader(getClass().getResource("/views/password.fxml"));

		try {
			root = passwordLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		PasswordController passwordController = passwordLoader.getController();
		passwordController.setStage(passwordWindow);

		Scene scene = new Scene(root);
		scene.getStylesheets().add("/views/gui.css");
		passwordWindow.setScene(scene);
		passwordWindow.setTitle("Password");
		passwordWindow.setResizable(false);
		passwordWindow.showAndWait();

		return passwordController.getPassword();
	}

	public Alert createErrorAlert(String text) {
		Alert alert = new Alert(Alert.AlertType.ERROR, text, ButtonType.CLOSE);
		DialogPane dialogPane = alert.getDialogPane();
		
		dialogPane.getStylesheets().add(getClass().getResource("/views/myDialogs.css").toExternalForm());
		dialogPane.getStyleClass().add("myDialog");

		return alert;
	}
}
