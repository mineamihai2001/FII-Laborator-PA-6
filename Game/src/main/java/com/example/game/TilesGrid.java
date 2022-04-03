package com.example.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import org.jgrapht.*;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

import java.util.Arrays;

public class TilesGrid implements Grid {
    private GridPane gridPane;
    private int[][] randomSticks;
    private Graph<Integer, DefaultEdge> sticks = new DefaultUndirectedGraph<>(DefaultEdge.class);


    TilesGrid() {
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
    }

    public void setRandomSticks(int width, int height) {

        randomSticks = new int[width][height];
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                int bit = (int) Math.floor(Math.random() * 2);
                randomSticks[i][j] = bit;

                sticks.addVertex(i * 10 + j);

            }
        }
    }

    public void getGraph() {
        System.out.println(sticks);
    }

    public Graph<Integer, DefaultEdge> createGrid(int width, int height) {
        setRandomSticks(width, height);

        for (int i = 0; i < height - 1; ++i) {
            for (int j = 0; j < width; ++j) {
                Rectangle stick1;
                Rectangle stick2;

                if (randomSticks[i][j] == 0) {
                    stick1 = new Rectangle(36, 0, Color.BLACK);
                } else {
                    stick1 = new Rectangle(36, 4, Color.BLACK);
                    System.out.println(j + " | " + i + " (" + (int) (j * 10 + i) + "->" + (int) (j * 10 + i + 1) + ")");
                    sticks.addEdge(j * 10 + i, j * 10 + i + 1);
                }
                if (randomSticks[j][i] == 0) {
                    stick2 = new Rectangle(0, 36, Color.BLACK);
                } else {
                    stick2 = new Rectangle(4, 36, Color.BLACK);
                    sticks.addEdge(i * 10 + j, i * 10 + j + 10);
                    System.out.println(i + " // " + j + " (" + (int) (i * 10 + j) + "->" + (int) (i * 10 + j + 10) + ")");
                }
                stick1.setStroke(Color.BLACK);
                stick2.setStroke(Color.BLACK);


                gridPane.add(stick1, i, j);
                gridPane.add(stick2, j, i);

                GridPane.setValignment(stick1, VPos.TOP);
                GridPane.setValignment(stick2, VPos.TOP);
            }
        }
        getGraph();
        return this.sticks;
    }


    public GridPane getGridPane() {
        return gridPane;
    }
}
