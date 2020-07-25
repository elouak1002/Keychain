package controllers;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.fxml.FXML;


public class Password {

    @FXML private Label statusLabel;
    @FXML private GridPane passwordGrid;

    @FXML
    public void initialize() {

        ObservableList<Node> list = passwordGrid.getChildren();
        for (Node node: list) {
            Button button = (Button) node;
            button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> System.out.println("hello1"));
            button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> System.out.println("hello2"));
        }

    }
}