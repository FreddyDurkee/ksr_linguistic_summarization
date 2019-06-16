package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Runner extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(Thread.currentThread().getContextClassLoader().getResource("mainwindow.fxml"));
//        loader.setController(new BasicSummarizationController());
        Parent root = loader.load();

        primaryStage.setTitle("Linguistic Summariazotor");
//        primaryStage.setMinHeight(600);
//        primaryStage.setMinWidth(900);
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
