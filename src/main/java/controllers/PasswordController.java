package controllers;


import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;

import javafx.collections.ObservableList;

import javafx.fxml.FXML;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;


public class PasswordController {

    @FXML
    private Label statusLabel;

    @FXML
    private GridPane passwordGrid;

    private ObservableList<Node> list;

    @FXML
    public void initialize() {

        this.list = passwordGrid.getChildren();

        fillGrid();
        registerEvents();
    }

    private void registerEvents() {

        for (Node node: this.list) {
            Button button = (Button) node;
            button.addEventHandler(MouseEvent.MOUSE_CLICKED, this::buttonEvent);
        }

    }

    private void buttonEvent(MouseEvent event) {
        Button source = (Button) event.getSource();
        if (!source.getText().equals("")) {
            statusLabel.setText("");

            fillGrid();
        }
        else {
            statusLabel.setText("Please click on a number!");
        }
    }

    private void fillGrid() {

        clearGrid();
        HashMap<Integer,Integer> positions = setUpRandomPosition();

        for (Map.Entry<Integer, Integer> pos : positions.entrySet()) {
            Button button = (Button) this.list.get(pos.getValue());
            button.setText(""+pos.getKey());
        }

    }

    private void clearGrid() {
        for (Node node: this.list) {
            Button button = (Button) node;
            button.setText("");
        }
    }

    private static HashMap<Integer,Integer> setUpRandomPosition() {

        HashMap<Integer, Integer> randomPos = new HashMap<>();
        LinkedList<Integer> alreadyUsed = new LinkedList<>();
        Random randomizer = new Random();

        for(int i=0; i<10;i++) {
            int position = randomizer.nextInt(25);
            while (alreadyUsed.contains(position)) {
                position =  randomizer.nextInt(25);
            }
            alreadyUsed.add(position);
            randomPos.put(i,position);
        }

        return randomPos;
    }

}