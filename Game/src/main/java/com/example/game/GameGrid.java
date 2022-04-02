package com.example.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class GameGrid implements Grid{
    private GridPane gridPane;

    GameGrid() {
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
    }

    public void createGrid(int width, int height) {
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                Circle node = new Circle(12, Color.rgb(237, 237, 237));
                node.setStroke(Color.rgb(135, 135, 135));
                gridPane.add(node, i, j);
                GridPane.setMargin(node, new Insets(6));
            }
        }

    }

    public GridPane getGridPane() {
        return gridPane;
    }
}
