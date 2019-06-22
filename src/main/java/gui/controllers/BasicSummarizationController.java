package gui.controllers;

import com.sun.org.apache.xml.internal.security.Init;
import data.FootballerRepository;
import data.QuantifierConfiguration;
import data.SummarizerConfiguration;
import fuzzyLogic.CompoundSummarizer;
import fuzzyLogic.LinguisticSummarizer;
import fuzzyLogic.Quantifier;
import fuzzyLogic.QualityMeasure;
import fuzzyLogic.variables.LinguisticVariable;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import lombok.Data;
import lombok.Setter;

import java.util.Arrays;

@Data
public class BasicSummarizationController {

    @FXML
    private ComboBox<SummarizationComposition> summarizerConnective;
    @FXML
    private Button generateBt;
    @FXML
    private PartController quantifierPartController;
    @FXML
    private PartController summarizer1PartController;
    @FXML
    private PartController summarizer2PartController;
    @FXML
    private TableView<QualityMeasure> summarizationTable;
    @FXML
    private TableColumn<QualityMeasure,String> DT_Sentence;
    @FXML
    private TableColumn<QualityMeasure,Double> DT_T1,DT_T2,DT_T3,DT_T4,DT_T5,DT_T6,DT_T7,DT_T8,DT_T9,DT_T10,DT_T11;

    private ObservableList<QualityMeasure> tabledQualityMeasures = FXCollections.observableArrayList();

    @Setter
    private FootballerRepository repository;

    @FXML
    void initialize() {
        Init.init();
        prepareDataTable();
        prepareQuantifier();
        prepareSummarizer(summarizer1PartController);
        prepareSummarizer(summarizer2PartController);

        summarizerConnective.setItems(FXCollections.observableList(Arrays.asList(SummarizationComposition.values())));
        BooleanBinding sum2Disabled = summarizerConnective.getSelectionModel().selectedItemProperty().isEqualTo(SummarizationComposition.NONE);
        summarizer2PartController.disableProperty().bind(sum2Disabled);

        summarizerConnective.getSelectionModel().selectFirst();

        generateBt.setOnAction(event -> {

            Quantifier quantifier = new Quantifier(quantifierPartController.getName(), quantifierPartController.getFunction());

            LinguisticVariable summarizer = LinguisticVariable.of(summarizer1PartController.getName(), summarizer1PartController.getFunction() , summarizer1PartController.getAttribute());
            switch (summarizerConnective.getValue()) {
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
            summarizer.fit(repository);

            String sentence = quantifier.getName() + " footballers are/have " + summarizer.getName();
            LinguisticSummarizer linguisticSummarizer = new CompoundSummarizer(sentence,summarizer,quantifier);
            tabledQualityMeasures.add(linguisticSummarizer.getMeasurements());
        });
    }


    private void prepareSummarizer(PartController summarizerPart) {
        summarizerPart.setConfigSupplier(SummarizerConfiguration.getInstance());
    }

    private void prepareQuantifier() {
        quantifierPartController.setConfigSupplier(QuantifierConfiguration.getInstance());
    }

    private void prepareDataTable() {
        summarizationTable.setItems(tabledQualityMeasures);
        summarizationTable.getSelectionModel().setCellSelectionEnabled(true);
        summarizationTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        MenuItem item = new MenuItem("Copy");
        item.setOnAction(event -> {
            StringBuilder clipboardString = new StringBuilder();
            for (QualityMeasure p : summarizationTable.getItems()) {
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
                new PropertyValueFactory<QualityMeasure,String>("sentence")
        );
        DT_T1.setCellValueFactory(
                new PropertyValueFactory<QualityMeasure,Double>("T1")
        );
        DT_T2.setCellValueFactory(
                new PropertyValueFactory<QualityMeasure,Double>("T2")
        );
        DT_T3.setCellValueFactory(
                new PropertyValueFactory<QualityMeasure,Double>("T3")
        );
        DT_T4.setCellValueFactory(
                new PropertyValueFactory<QualityMeasure,Double>("T4")
        );
        DT_T5.setCellValueFactory(
                new PropertyValueFactory<QualityMeasure,Double>("T5")
        );
        DT_T6.setCellValueFactory(
                new PropertyValueFactory<QualityMeasure,Double>("T6")
        );
        DT_T7.setCellValueFactory(
                new PropertyValueFactory<QualityMeasure,Double>("T7")
        );
        DT_T8.setCellValueFactory(
                new PropertyValueFactory<QualityMeasure,Double>("T8")
        );
        DT_T9.setCellValueFactory(
                new PropertyValueFactory<QualityMeasure,Double>("T9")
        );
        DT_T10.setCellValueFactory(
                new PropertyValueFactory<QualityMeasure,Double>("T10")
        );
        DT_T11.setCellValueFactory(
                new PropertyValueFactory<QualityMeasure,Double>("T11")
        );
    }
    

}
