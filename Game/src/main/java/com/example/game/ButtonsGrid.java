package com.example.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class ButtonsGrid implements Grid {
    private GridPane gridPane;
    private Graph<Integer, DefaultEdge> sticks = new DefaultUndirectedGraph<>(DefaultEdge.class);
    private List<Integer> pickedNodes;
    private int turn;


    ButtonsGrid() {
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        turn = 0;
        pickedNodes = new ArrayList<>();
        pickedNodes.add(-1);
    }

    public void createGrid(int width, int height, Graph<Integer, DefaultEdge> sticks) {
        this.sticks = sticks;
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                Circle node = new Circle(12, Color.TRANSPARENT);
                node.setStroke(Color.TRANSPARENT);
                gridPane.add(node, i, j);
                GridPane.setMargin(node, new Insets(6));
                getInput(node);
            }
        }

    }

    public void getInput(Circle node) {
        node.setOnMouseClicked(actionEvent -> {
            if (validMove(node)) {
                if (turn % 2 == 0) {
                    node.setFill(Color.DODGERBLUE);
                    ++turn;
                } else {
                    node.setFill(Color.INDIANRED);
                    ++turn;
                }
            } else {
                System.out.println("Invalid move!");
            }
        });
    }

    public boolean validMove(Circle node) {
        int i = GridPane.getRowIndex(node);
        int j = GridPane.getColumnIndex(node);
        System.out.println(sticks.edgesOf(i * 10 + j));

        int prevNode = pickedNodes.get(pickedNodes.size() - 1);
        int currentNode = i * 10 + j;
        System.out.println(isAdject(prevNode, currentNode) + "||" + wasPicked(i * 10 + j) + " || " + (sticks.edgesOf(i * 10 + j).size() > 0));
        if (isAdject(prevNode, currentNode) && wasPicked(i * 10 + j) && sticks.edgesOf(i * 10 + j).size() > 0) {
            pickedNodes.add(currentNode);
            return true;
        }
        return false;
    }

    public boolean isAdject(int prevNode, int currentNode) {
        if (prevNode != -1){
            System.out.println("PREV: " + prevNode + "; CURRENT: " + currentNode);
            System.out.println(sticks.edgesOf(prevNode));
            for (DefaultEdge i : sticks.edgesOf(prevNode)) {
                int adject1 = sticks.getEdgeSource(i);
                int adject2 = sticks.getEdgeTarget(i);
                System.out.println("$$$$$$");
                System.out.println("ADJECT1: " + sticks.getEdgeSource(i));
                System.out.println("ADJECT2: " + sticks.getEdgeTarget(i));
                if (adject1 == currentNode || adject2 == currentNode) return true;
            }
            return false;
        }
        else return true;
    }

    public boolean wasPicked(int node) {
        for (Integer i : pickedNodes) {
            if (node == i) {
                return false;
            }
        }
        return true;
    }

    public GridPane getGridPane() {
        return gridPane;
    }
}