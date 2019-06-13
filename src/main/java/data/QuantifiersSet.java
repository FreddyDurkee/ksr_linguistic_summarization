package data;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class QuantifiersSet {
    private Map<String, FunctionParameters> quantifierSetForTriangularFunction = new HashMap<>();
    private Map<String, FunctionParameters> quantifierSetForTrapezoidalFunction = new HashMap<>();

    public QuantifiersSet() {
        quantifierSetForTriangularFunction.put("Almost none", new FunctionParameters(0.0,0.0,0.2));
        quantifierSetForTriangularFunction.put("Some", new FunctionParameters(0.12,0.25,0.4));
        quantifierSetForTriangularFunction.put("About half", new FunctionParameters(0.35,0.5,0.65));
        quantifierSetForTriangularFunction.put("Many", new FunctionParameters(0.6,0.75,0.9));
        quantifierSetForTriangularFunction.put("Almost all", new FunctionParameters(0.85,0.99,1.5));
    }





}
