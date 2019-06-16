package gui.controllers;

import data.FunctionParameters;
import data.QuantifiersSet;
import com.sun.org.apache.xml.internal.security.Init;
import data.Set;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class BasicSummarizationController {

    private List<String> quantifiersNames;
    private QuantifiersSet quantifiersSet = new QuantifiersSet();

    @FXML
    private Spinner<Double> quantParamA, quantParamB, quantParamC, quantParamD;
    @FXML
    private RadioButton quantifierTriangularFunRB, quantifierTrapezoidalFunRB;
    @FXML
    private ComboBox<String> quantifierChooser, summarizerChoozer;
    @FXML
    private ToggleGroup quantifierGroup;

    public BasicSummarizationController() {
        quantifiersNames = new ArrayList<>(quantifiersSet.getSetForTriangularFunction().keySet());
    }

    @FXML
    void initialize() {
        Init.init();
        quantifierChooser.setItems(FXCollections.observableList(quantifiersNames));
        quantifierChooser.getSelectionModel().selectFirst();
        String firstElement = quantifiersNames.get(0);
        if (quantifierTriangularFunRB.isSelected()) {
            reloadParameters(quantifiersSet, quantifierChooser, quantifierTriangularFunRB.getText());
        } else if (quantifierTrapezoidalFunRB.isSelected()) {
            reloadParameters(quantifiersSet, quantifierChooser, quantifierTrapezoidalFunRB.getText());
        }


        quantifierGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            RadioButton rb = (RadioButton) quantifierGroup.getSelectedToggle();
            reloadParameters(quantifiersSet, quantifierChooser, rb.getText());
        });

        quantifierChooser.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (quantifierTriangularFunRB.isSelected()) {
                reloadParameters(quantifiersSet, quantifierChooser, quantifierTriangularFunRB.getText());
            } else if (quantifierTrapezoidalFunRB.isSelected()) {
                reloadParameters(quantifiersSet, quantifierChooser, quantifierTrapezoidalFunRB.getText());
            }
        });
    }

    private void reloadParameters(Set set, ComboBox<String> chooser, String rbText){
        if (rbText.equals("triangular function")) {
            quantParamD.setDisable(true);
            FunctionParameters parameters = set.getSetForTriangularFunction().get(chooser.getValue());
            setDefaultSprinnersValue(parameters, false);
        } else if (rbText.equals("trapezoidal function")) {
            quantParamD.setDisable(false);
            FunctionParameters parameters = set.getSetForTrapezoidalFunction().get(chooser.getValue());
            setDefaultSprinnersValue(parameters, true);
        }
        else {
            throw new IllegalArgumentException("Missing function type!");
        }

    }


    private void setDefaultSprinnersValue(FunctionParameters parameters, boolean isD) {
        quantParamA.getValueFactory().setValue(parameters.getA());
        quantParamB.getValueFactory().setValue(parameters.getB());
        quantParamC.getValueFactory().setValue(parameters.getC());
        if (isD) {
            quantParamD.getValueFactory().setValue(parameters.getD());
        }
    }

}
