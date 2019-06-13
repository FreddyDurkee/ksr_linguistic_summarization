package Gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Gui.Controller;

import java.io.IOException;

public class Runner extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Thread.currentThread().getContextClassLoader().getResource("mainwindow.fxml"));
//        loader.setController(new Controller());
        Parent root = loader.load();

        primaryStage.setTitle("Linguistic Summariazotor");
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(600);
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
