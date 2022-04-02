module com.example.game {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jgrapht.core;


    opens com.example.game to javafx.fxml;
    exports com.example.game;
}