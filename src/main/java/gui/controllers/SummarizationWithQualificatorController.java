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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.util.ArrayList;
import java.util.List;

public class SummarizationWithQualificatorController {

    private List<String> quantifiersNames;
    private QuantifiersSet quantifiersSet = new QuantifiersSet();

    @FXML
    private Spinner<Double> quantParamA, quantParamB, quantParamC, quantParamD;
    @FXML
    private Spinner<Double> qualParamA, qualParamB, qualParamC, qualParamD;
    @FXML
    private Spinner<Double> sumParamA, sumParamB, sumParamC, sumParamD;
    @FXML
    private RadioButton quantifierTriangularFunRB, quantifierTrapezoidalFunRB;
    @FXML
    private RadioButton qualTriangularFunRB, qualTrapezoidalFunRB;
    @FXML
    private RadioButton summarizerTriangularFunRB, summarizerTrapezoidalFunRB;
    @FXML
    private ComboBox<String> quantifierChooser, qualifierChooser, summarizerChooser;
    @FXML
    private Button generateBt;
    @FXML
    private ToggleGroup quantifierGroup, qualGroup, summarizerGroup;
    @FXML
    private TableView<Result> summarizationTable;
    private ObservableList<Result> tabledResults = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Result, String> DT_Sentence;
    @FXML
    private TableColumn<Result, Double> DT_T1, DT_T2, DT_T3, DT_T4, DT_T5, DT_T6, DT_T7, DT_T8, DT_T9, DT_T10, DT_T11;


    public SummarizationWithQualificatorController() {
        quantifiersNames = new ArrayList<>(quantifiersSet.getSetForTriangularFunction().keySet());
    }

    @FXML
    void initialize() {
        Init.init();
        prepareDataTable();
        quantifierChooser.setItems(FXCollections.observableList(quantifiersNames));
        quantifierChooser.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (quantifierTriangularFunRB.isSelected()) {
                reloadParameters(quantifiersSet, quantifierChooser, quantifierTriangularFunRB.getText());
            } else if (quantifierTrapezoidalFunRB.isSelected()) {
                reloadParameters(quantifiersSet, quantifierChooser, quantifierTrapezoidalFunRB.getText());
            }
        });

        quantParamD.disableProperty().bind(quantifierTrapezoidalFunRB.selectedProperty().not());
        qualParamD.disableProperty().bind(qualTrapezoidalFunRB.selectedProperty().not());
        sumParamD.disableProperty().bind(summarizerTrapezoidalFunRB.selectedProperty().not());


        quantifierGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            RadioButton rb = (RadioButton) quantifierGroup.getSelectedToggle();
            reloadParameters(quantifiersSet, quantifierChooser, rb.getText());
        });


        quantifierChooser.getSelectionModel().selectFirst();
        generateBt.setOnAction(event -> {
            Function quantifierFunction, quantFunction, summarizerFunction;
            if (quantifierTriangularFunRB.isSelected()) {
                quantifierFunction = new TriangularFunction(quantParamA.getValue(), quantParamB.getValue(), quantParamC.getValue());
            } else {
                quantifierFunction = new TrapezoidalFunction(quantParamA.getValue(), quantParamB.getValue(), quantParamC.getValue(), quantParamD.getValue());
            }

            if (qualTriangularFunRB.isSelected()) {
                quantFunction = new TriangularFunction(qualParamA.getValue(), qualParamB.getValue(), qualParamC.getValue());
            } else {
                quantFunction = new TrapezoidalFunction(qualParamA.getValue(), qualParamB.getValue(), qualParamC.getValue(), qualParamD.getValue());
            }

            if (summarizerTriangularFunRB.isSelected()) {
                summarizerFunction = new TriangularFunction(sumParamA.getValue(), sumParamB.getValue(), sumParamC.getValue());
            } else {
                summarizerFunction = new TrapezoidalFunction(sumParamA.getValue(), sumParamB.getValue(), sumParamC.getValue(), sumParamD.getValue());
            }
            Quantifier quantifier = new Quantifier(quantifierChooser.getValue(), quantifierFunction);
            LinguisticVariable summarizer = LinguisticVariable.of("age about 30", summarizerFunction, new Attribute());
            LinguisticVariable qualifier = LinguisticVariable.of("obojetnie", quantFunction, new Attribute());

            String sentence = quantifier.getName() + " footballers being / having " + qualifier.getName() + " are / have " + summarizer.getName();
            QualityMeasure qualityMeasure = new QualityMeasureWithQualifier(quantifier, summarizer, qualifier);
            LinguisticSummarizer linguisticSummarizer = new LinguisticSummarizer(sentence, qualityMeasure);
            tabledResults.add(linguisticSummarizer.getMeasurements());
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

    private void prepareDataTable() {
        summarizationTable.setItems(tabledResults);
        summarizationTable.getSelectionModel().setCellSelectionEnabled(true);
        summarizationTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        MenuItem item = new MenuItem("Copy");
        item.setOnAction(event -> {
            StringBuilder clipboardString = new StringBuilder();
            for (Result p : summarizationTable.getItems()) {
                clipboardString.append(p);
                clipboardString.append('\n');
            }
            final ClipboardContent content = new ClipboardContent();
            content.putString(clipboardString.toString());
            Clipboard.getSystemClipboard().setContent(content);
        });
        ContextMenu menu = new ContextMenu();
        menu.getItems().add(item);
        summarizationTable.setContextMenu(menu);

        DT_Sentence.setCellValueFactory(
                new PropertyValueFactory<Result, String>("sentence")
        );
        DT_T1.setCellValueFactory(
                new PropertyValueFactory<Result, Double>("T1")
        );
        DT_T2.setCellValueFactory(
                new PropertyValueFactory<Result, Double>("T2")
        );
        DT_T3.setCellValueFactory(
                new PropertyValueFactory<Result, Double>("T3")
        );
        DT_T4.setCellValueFactory(
                new PropertyValueFactory<Result, Double>("T4")
        );
        DT_T5.setCellValueFactory(
                new PropertyValueFactory<Result, Double>("T5")
        );
        DT_T6.setCellValueFactory(
                new PropertyValueFactory<Result, Double>("T6")
        );
        DT_T7.setCellValueFactory(
                new PropertyValueFactory<Result, Double>("T7")
        );
        DT_T8.setCellValueFactory(
                new PropertyValueFactory<Result, Double>("T8")
        );
        DT_T9.setCellValueFactory(
                new PropertyValueFactory<Result, Double>("T9")
        );
        DT_T10.setCellValueFactory(
                new PropertyValueFactory<Result, Double>("T10")
        );
        DT_T11.setCellValueFactory(
                new PropertyValueFactory<Result, Double>("T11")
        );
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
