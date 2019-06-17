package gui.controllers;

import com.sun.org.apache.xml.internal.security.Init;
import data.QuantifierConfiguration;
import data.SummarizerConfiguration;
import fuzzyLogic.LinguisticSummarizer;
import fuzzyLogic.QualityMeasure;
import fuzzyLogic.Quantifier;
import fuzzyLogic.Result;
import fuzzyLogic.variables.LinguisticVariable;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.util.Arrays;

public class BasicSummarizationController {

    @FXML
    private ComboBox<SummarizationComposition> summarizerComposer;
    @FXML
    private Button generateBt;
    @FXML
    private PartController quantifierPartController;
    @FXML
    private PartController summarizer1PartController;
    @FXML
    private PartController summarizer2PartController;
    @FXML
    private TableView<Result> summarizationTable;
    @FXML
    private TableColumn<Result,String> DT_Sentence;
    @FXML
    private TableColumn<Result,Double> DT_T1,DT_T2,DT_T3,DT_T4,DT_T5,DT_T6,DT_T7,DT_T8,DT_T9,DT_T10,DT_T11;

    private ObservableList<Result> tabledResults = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        Init.init();
        prepareDataTable();
        prepareQuantifier();
        prepareSummarizer(summarizer1PartController);
        prepareSummarizer(summarizer2PartController);

        summarizerComposer.setItems(FXCollections.observableList(Arrays.asList(SummarizationComposition.values())));
        BooleanBinding sum2Disabled = summarizerComposer.getSelectionModel().selectedItemProperty().isEqualTo(SummarizationComposition.NONE);
        summarizer2PartController.disableProperty().bind(sum2Disabled);

        summarizerComposer.getSelectionModel().selectFirst();

        generateBt.setOnAction(event -> {

            Quantifier quantifier = new Quantifier(quantifierPartController.getName(), quantifierPartController.getFunction());

            LinguisticVariable summarizer = LinguisticVariable.of(summarizer1PartController.getName(), summarizer1PartController.getFunction() , summarizer1PartController.getAttribute());
            switch (summarizerComposer.getValue()) {
                case NONE:
                    break;
                case OR:
                    summarizer = summarizer.or(LinguisticVariable.of(summarizer2PartController.getName(), summarizer2PartController.getFunction(), summarizer2PartController.getAttribute()));
                    break;
                case AND:
                    summarizer = summarizer.and(LinguisticVariable.of(summarizer2PartController.getName(), summarizer2PartController.getFunction(), summarizer2PartController.getAttribute()));
                    break;
                default:
                    throw new IllegalStateException("Illegal connective.");
            }

            String sentence = quantifier.getName() + " footballers are/have " + summarizer.getName();
            QualityMeasure qualityMeasure = new QualityMeasure(quantifier, summarizer);
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
                new PropertyValueFactory<Result,String>("sentence")
        );
        DT_T1.setCellValueFactory(
                new PropertyValueFactory<Result,Double>("T1")
        );
        DT_T2.setCellValueFactory(
                new PropertyValueFactory<Result,Double>("T2")
        );
        DT_T3.setCellValueFactory(
                new PropertyValueFactory<Result,Double>("T3")
        );
        DT_T4.setCellValueFactory(
                new PropertyValueFactory<Result,Double>("T4")
        );
        DT_T5.setCellValueFactory(
                new PropertyValueFactory<Result,Double>("T5")
        );
        DT_T6.setCellValueFactory(
                new PropertyValueFactory<Result,Double>("T6")
        );
        DT_T7.setCellValueFactory(
                new PropertyValueFactory<Result,Double>("T7")
        );
        DT_T8.setCellValueFactory(
                new PropertyValueFactory<Result,Double>("T8")
        );
        DT_T9.setCellValueFactory(
                new PropertyValueFactory<Result,Double>("T9")
        );
        DT_T10.setCellValueFactory(
                new PropertyValueFactory<Result,Double>("T10")
        );
        DT_T11.setCellValueFactory(
                new PropertyValueFactory<Result,Double>("T11")
        );
    }
    

}
