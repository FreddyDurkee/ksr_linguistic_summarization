package gui.controllers;

import com.sun.org.apache.xml.internal.security.Init;
import data.*;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummarizationWithQualificatorController {


    @FXML
    private Button generateBt;
    @FXML
    private PartController quantifierPartController;
    @FXML
    private PartController qualifierPartController;
    @FXML
    private PartController summarizerPartController;

    @FXML
    private TableView<Result> summarizationTable;
    private ObservableList<Result> tabledResults = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Result, String> DT_Sentence;
    @FXML
    private TableColumn<Result, Double> DT_T1, DT_T2, DT_T3, DT_T4, DT_T5, DT_T6, DT_T7, DT_T8, DT_T9, DT_T10, DT_T11;


    @FXML
    void initialize() {
        Init.init();
        prepareDataTable();
        prepareQuantifier();
        prepareSummarizer(qualifierPartController);
        prepareSummarizer(summarizerPartController);


        generateBt.setOnAction(event -> {

            Quantifier quantifier = new Quantifier(quantifierPartController.getName(), quantifierPartController.getFunction());
            LinguisticVariable summarizer = LinguisticVariable.of(summarizerPartController.getName(), summarizerPartController.getFunction(), summarizerPartController.getAttribute());
            LinguisticVariable qualifier = LinguisticVariable.of(qualifierPartController.getName(), qualifierPartController.getFunction(), qualifierPartController.getAttribute());


            String sentence = quantifierPartController.getName() + " footballers being / having " + qualifierPartController.getName() + " are / have " + summarizerPartController.getName();
            QualityMeasure qualityMeasure = new QualityMeasureWithQualifier(quantifier, summarizer, qualifier);
            LinguisticSummarizer linguisticSummarizer = new LinguisticSummarizer(sentence, qualityMeasure);
            tabledResults.add(linguisticSummarizer.getMeasurements());
        });
    }


    private void prepareSummarizer(PartController summarizerPart) {
        summarizerPart.setConfigSupplier(SummarizerConfiguration.getInstance());
    }

    private void prepareQuantifier() {
        quantifierPartController.setConfigSupplier(QuantifierConfiguration.getInstance());
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
}
