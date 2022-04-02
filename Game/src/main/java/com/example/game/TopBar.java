package com.example.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;

public class TopBar extends Node {
    private final HBox hBox = new HBox();
    private final TextField widthInput = new TextField();
    private final TextField heightInput = new TextField();
    private final Button createBtn = new Button("Create");
    Label text = new Label("Grid size:");
    private int width = -1;
    private int height = -1;

    public void createTop() {
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-background-color: #dbdbdb");
        widthInput.setPrefWidth(40);
        heightInput.setPrefWidth(40);

        hBox.getChildren().addAll(text, widthInput, heightInput, createBtn);
        HBox.setMargin(widthInput, new Insets(10, 5, 20, 5));
        HBox.setMargin(heightInput, new Insets(10, 0, 20, 5));
        HBox.setMargin(createBtn, new Insets(10, 10, 20, 5));
        HBox.setMargin(text, new Insets(10, 0, 20, 0));

    }

    public void getInput(GameGrid grid, TilesGrid tilesGrid, ButtonsGrid buttonsGrid) {
        createBtn.setOnAction(actionEvent -> {
            width = Integer.parseInt(widthInput.getText());
            height = Integer.parseInt(heightInput.getText());

            Graph<Integer, DefaultEdge> sticks;
            grid.createGrid(width, height);
            sticks = tilesGrid.createGrid(width, height);
            buttonsGrid.createGrid(width, height, sticks);

            System.out.println(width);
            System.out.println(height);
        });
    }

    public HBox gethBox() {
        return hBox;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
