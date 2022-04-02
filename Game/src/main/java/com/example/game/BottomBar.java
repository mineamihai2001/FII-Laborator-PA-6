package com.example.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class BottomBar extends Node {
    private final HBox hBox = new HBox();
    private final Button loadBtn = new Button("Load");
    private final Button saveBtn = new Button("Save");

    public void createBottom() {
        Label text = new Label("Grid size:");
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-background-color: #dbdbdb");


        hBox.getChildren().addAll(loadBtn, saveBtn);
        HBox.setMargin(loadBtn, new Insets(10, 10, 20, 10));
        HBox.setMargin(saveBtn, new Insets(10, 10, 20, 10));
    }


    public HBox gethBox() {
        return hBox;
    }

}
