package gui.controllers;

import com.sun.org.apache.xml.internal.security.Init;
import data.FunctionParameters;
import data.Preconfigured;
import fuzzyLogic.Attribute;
import fuzzyLogic.functions.Function;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;

import java.util.Arrays;

public class PartController {

    private Preconfigured configSupplier;

    @FXML
    private Spinner<Double> paramA, paramB, paramC, paramD;

    @FXML
    private ComboBox<String> chooser;

    @FXML
    private ComboBox<Function.FunctionType> functionType;

    private BooleanProperty disable = new SimpleBooleanProperty(false);



    @FXML
    void initialize() {
        Init.init();
        functionType.setItems(FXCollections.observableList(Arrays.asList(Function.FunctionType.values())));
        functionType.valueProperty().addListener((observable, oldValue, newValue) -> {
            Function.FunctionType ftype = newValue;
            chooser.setItems(FXCollections.observableList(configSupplier.getNames(ftype)));
        });
        chooser.valueProperty().addListener((observable, oldValue, newValue) -> {
            String name = newValue;
            FunctionParameters params = configSupplier.getParametersFor(name, functionType.getValue());
            if(params != null){
                setParams(params);
            }
        });

        chooser.disableProperty().bind(disable);
        paramA.disableProperty().bind(disable);
        paramB.disableProperty().bind(disable);
        paramC.disableProperty().bind(disable);
        BooleanBinding isNotTrapezoidal = functionType.valueProperty().isNotEqualTo(Function.FunctionType.TRAPEZOIDAL);
        paramD.disableProperty().bind(Bindings.or(disable,isNotTrapezoidal));
        functionType.disableProperty().bind(disable);
    }

    public void setConfigSupplier(Preconfigured configSupplier) {
        this.configSupplier = configSupplier;
        functionType.getSelectionModel().selectFirst();
        chooser.getSelectionModel().selectFirst();
    }

    private void setParams(FunctionParameters params) {
        paramA.getValueFactory().setValue(params.getA());
        paramB.getValueFactory().setValue(params.getB());
        paramC.getValueFactory().setValue(params.getC());
        if (functionType.getValue() == Function.FunctionType.TRAPEZOIDAL) {
            paramD.getValueFactory().setValue(params.getD());
        }else{
            paramD.getValueFactory().setValue(0.0);
        }
    }


    public BooleanProperty disableProperty() {
        return disable;
    }

    public Function getFunction() {
        return Function.of(functionType.getValue(),paramA.getValue(),paramB.getValue(),paramC.getValue(),paramD.getValue());
    }

    public String getName() {
        return chooser.getValue();
    }

    public Attribute getAttribute() {
        return configSupplier.getAttributeFor(chooser.getValue(), functionType.getValue());
    }
}
