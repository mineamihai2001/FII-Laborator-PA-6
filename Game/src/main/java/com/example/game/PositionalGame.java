package com.example.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PositionalGame extends Application {

    public Parent createContent() {
        BorderPane root = new BorderPane();
        GameGrid grid = new GameGrid();
        TilesGrid tilesGrid = new TilesGrid();
        TopBar topBar = new TopBar();
        BottomBar bottomBar = new BottomBar();
        StackPane mainBoard = new StackPane();
        ButtonsGrid buttonsGrid = new ButtonsGrid();

        root.setPrefSize(400, 600);

        topBar.createTop();
        root.setTop(topBar.gethBox());
        bottomBar.createBottom();
        root.setBottom(bottomBar.gethBox());

        topBar.getInput(grid, tilesGrid, buttonsGrid);

        mainBoard.setAlignment(Pos.CENTER);
        mainBoard.getChildren().addAll(grid.getGridPane(), tilesGrid.getGridPane(), buttonsGrid.getGridPane());

//        bottomBar.takePicture(mainBoard);
        root.setCenter(mainBoard);
//        root.setCenter(grid.getGridPane());

        return root;
    }

    @Override
    public void start(Stage mainStage) throws Exception {
        Scene scene = new Scene(createContent());

        mainStage.setTitle("PositionalGame");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
