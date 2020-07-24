package controllers;

import javafx.fxml.FXML;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;

public class Client {

	@FXML private TextField usernameField;
	@FXML private PasswordField passwordField;
    @FXML private Button connectButton;
	@FXML private ListView<String> filesList = new ListView<>();
    @FXML private TextArea fileArea;
    @FXML private Label fileName;
	@FXML private Label fileStatus;
	@FXML private Label connectionStatus;

	public void initialize() {
	}




}