package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("PAYE and Deduction Calculator");
        MainApp main =  new MainApp();
        Scene m = null;
        m = main.getMain();
        stage.setX(20);
        stage.setX(20);
        stage.setScene(m);
        stage.setResizable(true);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}