package Gui;

import Data.QuantifiersSet;
import com.sun.org.apache.xml.internal.security.Init;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<String> quantifiersNames;

    @FXML
    private ComboBox<String> quantifierChooser, summarizerChoozer;

    public Controller() {
        QuantifiersSet quantifiersSet = new QuantifiersSet();
        quantifiersNames = new ArrayList<>(quantifiersSet.getQuantifierSetForTriangularFunction().keySet());
    }

    @FXML
    void initialize() {
        Init.init();
        quantifierChooser.setItems(FXCollections.observableList(quantifiersNames));
        quantifierChooser.getSelectionModel().selectFirst();
    }
}
