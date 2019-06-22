package gui.controllers;

import data.FootballerRepository;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class RootController {
    @FXML
    private TabPane tabPane;

    @FXML private Tab basicSummarizationTab;

    @FXML private BasicSummarizationController basicSumTabController;
    @FXML private SummarizationWithQualificatorController SumWithQualifierTabController;

    @FXML
    void initialize() {
        FootballerRepository repository = new FootballerRepository();
        repository.loadFromCSV(Thread.currentThread().getContextClassLoader().getResource("footballers.csv").getPath());
        basicSumTabController.setRepository(repository);
        SumWithQualifierTabController.setRepository(repository);
    }

}
