package gui.controllers;

import data.FunctionParameters;
import data.QuantifiersSet;
import com.sun.org.apache.xml.internal.security.Init;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;

import java.util.ArrayList;
import java.util.List;

public class BasicSummarizationController {

    private List<String> quantifiersNames;
    private QuantifiersSet quantifiersSet = new QuantifiersSet();

    @FXML
    private Spinner quantParamA, quantParamB, quantParamC, quantParamD;
    @FXML
    private RadioButton quantifierTriangularFunRB, quantifierTrapezoidalFunRB;
    @FXML
    private ComboBox<String> quantifierChooser, summarizerChoozer;

    public BasicSummarizationController() {

        quantifiersNames = new ArrayList<>(quantifiersSet.getQuantifierSetForTriangularFunction().keySet());
    }

    @FXML
    void initialize() {
        Init.init();
        quantifierChooser.setItems(FXCollections.observableList(quantifiersNames));
        quantifierChooser.getSelectionModel().selectFirst();
        String firstElement = quantifiersNames.get(0);
        if(quantifierTriangularFunRB.isSelected()){
            FunctionParameters parameters = quantifiersSet.getQuantifierSetForTriangularFunction().get(firstElement);
//            quantParamA.getValueFactory().setValue(parameters.getA());
        }
    }
}
