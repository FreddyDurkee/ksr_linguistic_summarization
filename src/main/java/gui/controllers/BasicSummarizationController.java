package gui.controllers;

import com.sun.org.apache.xml.internal.security.Init;
import data.FunctionParameters;
import data.QuantifiersSet;
import data.Set;
import fuzzyLogic.*;
import fuzzyLogic.functions.Function;
import fuzzyLogic.functions.TrapezoidalFunction;
import fuzzyLogic.functions.TriangularFunction;
import fuzzyLogic.variables.LinguisticVariable;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicSummarizationController {

    private List<String> quantifiersNames;
    private QuantifiersSet quantifiersSet = new QuantifiersSet();

    @FXML
    private Spinner<Double> quantParamA, quantParamB, quantParamC, quantParamD;
    @FXML
    private Spinner<Double> sumParamA1, sumParamB1, sumParamC1, sumParamD1;
    @FXML
    private Spinner<Double> sumParamA2, sumParamB2, sumParamC2, sumParamD2;
    @FXML
    private RadioButton quantifierTriangularFunRB, quantifierTrapezoidalFunRB;
    @FXML
    private RadioButton summarizerTriangularFunRB1, summarizerTrapezoidalFunRB1;
    @FXML
    private RadioButton summarizerTriangularFunRB2, summarizerTrapezoidalFunRB2;
    @FXML
    private ComboBox<String> quantifierChooser, summarizerChoozer1, summarizerChoozer2;
    @FXML
    private ComboBox<SummarizationComposition> summarizerComposer;
    @FXML
    private Button generateBt;
    @FXML
    private ToggleGroup quantifierGroup, summarizerGroup1, summarizerGroup2;
    @FXML
    private ListView summarizationList;

    public BasicSummarizationController() {
        quantifiersNames = new ArrayList<>(quantifiersSet.getSetForTriangularFunction().keySet());
    }

    @FXML
    void initialize() {
        Init.init();
        quantifierChooser.setItems(FXCollections.observableList(quantifiersNames));
        summarizerComposer.setItems(FXCollections.observableList(Arrays.asList(SummarizationComposition.values())));
        BooleanBinding sum2Disabled = summarizerComposer.getSelectionModel().selectedItemProperty().isEqualTo(SummarizationComposition.NONE);
        summarizerChoozer2.disableProperty().bind(sum2Disabled);
        sumParamA2.disableProperty().bind(sum2Disabled);
        sumParamB2.disableProperty().bind(sum2Disabled);
        sumParamC2.disableProperty().bind(sum2Disabled);
        sumParamD2.disableProperty().bind(sum2Disabled);
        summarizerTriangularFunRB2.disableProperty().bind(sum2Disabled);
        summarizerTrapezoidalFunRB2.disableProperty().bind(sum2Disabled);

        quantifierChooser.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (quantifierTriangularFunRB.isSelected()) {
                reloadParameters(quantifiersSet, quantifierChooser, quantifierTriangularFunRB.getText());
            } else if (quantifierTrapezoidalFunRB.isSelected()) {
                reloadParameters(quantifiersSet, quantifierChooser, quantifierTrapezoidalFunRB.getText());
            }
        });

        quantParamD.disableProperty().bind(quantifierTrapezoidalFunRB.selectedProperty().not());
        sumParamD1.disableProperty().bind(summarizerTrapezoidalFunRB1.selectedProperty().not());
        sumParamD2.disableProperty().bind(summarizerTrapezoidalFunRB2.selectedProperty().not());


        quantifierGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            RadioButton rb = (RadioButton) quantifierGroup.getSelectedToggle();
            reloadParameters(quantifiersSet, quantifierChooser, rb.getText());
        });


        summarizerComposer.getSelectionModel().selectFirst();
        quantifierChooser.getSelectionModel().selectFirst();
        generateBt.setOnAction(event -> {
            Function quantifierFunction, summarizerFunction1, summarizerFunction2;
            if (quantifierTriangularFunRB.isSelected()) {
                quantifierFunction = new TriangularFunction(quantParamA.getValue(), quantParamB.getValue(), quantParamC.getValue());
            } else {
                quantifierFunction = new TrapezoidalFunction(quantParamA.getValue(), quantParamB.getValue(), quantParamC.getValue(), quantParamD.getValue());
            }

            if (summarizerTriangularFunRB1.isSelected()) {
                summarizerFunction1 = new TriangularFunction(sumParamA1.getValue(), sumParamB1.getValue(), sumParamC1.getValue());
            } else {
                summarizerFunction1 = new TrapezoidalFunction(sumParamA1.getValue(), sumParamB1.getValue(), sumParamC1.getValue(), sumParamD1.getValue());
            }

            if (summarizerTriangularFunRB2.isSelected()) {
                summarizerFunction2 = new TriangularFunction(sumParamA2.getValue(), sumParamB2.getValue(), sumParamC2.getValue());
            } else {
                summarizerFunction2 = new TrapezoidalFunction(sumParamA2.getValue(), sumParamB2.getValue(), sumParamC2.getValue(), sumParamD2.getValue());
            }
            Quantifier quantifier = new Quantifier(quantifierChooser.getValue(), quantifierFunction);
            SummarizationComposition composer = summarizerComposer.getValue();
            LinguisticVariable summarizer;
            switch (composer) {
                case NONE:
                    summarizer = LinguisticVariable.of("age about 30", summarizerFunction1, new Attribute());
                    break;
                case OR:
                    summarizer = LinguisticVariable.of("age about 30", summarizerFunction1, new Attribute()).or(LinguisticVariable.of("age about 30", summarizerFunction2, new Attribute()));
                    break;
                case AND:
                    summarizer = LinguisticVariable.of("age about 30", summarizerFunction1, new Attribute()).and(LinguisticVariable.of("age about 30", summarizerFunction2, new Attribute()));
                    break;
                default:
                    throw new IllegalStateException("Illegal connective.");
            }


            LinguisticSummarizer linguisticSummarizer = new LinguisticSummarizer(quantifier, summarizer);

            ObservableList<String> items = FXCollections.observableArrayList(
                    linguisticSummarizer.getSentence(QualityMeasure.Measure.T1));
            summarizationList.setItems(items);
        });
    }

    private void reloadParameters(Set set, ComboBox<String> chooser, String rbText) {
        if (rbText.equals("triangular function")) {
            FunctionParameters parameters = set.getSetForTriangularFunction().get(chooser.getValue());
            setDefaultSprinnersValue(parameters, false);
        } else if (rbText.equals("trapezoidal function")) {
            FunctionParameters parameters = set.getSetForTrapezoidalFunction().get(chooser.getValue());
            setDefaultSprinnersValue(parameters, true);
        } else {
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
