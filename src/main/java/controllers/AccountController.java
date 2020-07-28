package controllers;

import javafx.fxml.FXML;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AccountController {

    @FXML private VBox vRoot;
    @FXML private Label title;
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private Label error;
    @FXML private Button create;

    @FXML
    public void initialize() {
        vRoot.setId("cb");
        title.setId("title");
    }

}