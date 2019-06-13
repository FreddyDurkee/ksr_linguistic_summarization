package gui.controllers;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class RootController {
    @FXML
    private TabPane tabPane;

    @FXML private Tab basicSummarizationTab;

    @FXML private BasicSummarizationController basicSummarizationController;


    public void init() {
        tabPane.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Tab> observable,
                                                                        Tab oldValue, Tab newValue) -> {
            if (newValue == basicSummarizationTab) {
                System.out.println("basicSummarizationTab");
            } else {
                System.out.println("- another Tab -");
            }
        });
    }
}
