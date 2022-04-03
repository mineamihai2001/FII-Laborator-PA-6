package com.example.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.io.File;

public class BottomBar extends Node {
    private final HBox hBox = new HBox();
    private final Button loadBtn = new Button("Load");
    private final Button saveBtn = new Button("Save");
    private final Button pictureBtn = new Button("Take Picture");

    public void createBottom() {
        Label text = new Label("Grid size:");
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-background-color: #dbdbdb");


        hBox.getChildren().addAll(loadBtn, saveBtn, pictureBtn);
        HBox.setMargin(loadBtn, new Insets(10, 10, 20, 10));
        HBox.setMargin(saveBtn, new Insets(10, 10, 20, 10));
        HBox.setMargin(pictureBtn, new Insets(10, 10, 20, 10));
    }

    public void takePicture(StackPane mainBoard) {
        pictureBtn.setOnAction(actionEvent -> {
            WritableImage snapshot = mainBoard.snapshot(new SnapshotParameters(), null);
            System.out.println(snapshot);
            Image image = new Image("test.png");
            ImageView imageView = new ImageView(snapshot);
            imageView.setImage(image);
        });
    }


    public HBox gethBox() {
        return hBox;
    }

}
