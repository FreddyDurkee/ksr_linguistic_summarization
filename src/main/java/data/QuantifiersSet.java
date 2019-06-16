package data;

import java.util.HashMap;
import java.util.Map;

public class QuantifiersSet implements  Set{
    private Map<String, FunctionParameters> quantifierSetForTriangularFunction = new HashMap<>();
    private Map<String, FunctionParameters> quantifierSetForTrapezoidalFunction = new HashMap<>();

    public QuantifiersSet() {
        quantifierSetForTriangularFunction.put("Almost none", new FunctionParameters(0.0,0.0,0.2));
        quantifierSetForTriangularFunction.put("Some", new FunctionParameters(0.12,0.25,0.4));
        quantifierSetForTriangularFunction.put("About half", new FunctionParameters(0.35,0.5,0.65));
        quantifierSetForTriangularFunction.put("Many", new FunctionParameters(0.6,0.75,0.9));
        quantifierSetForTriangularFunction.put("Almost all", new FunctionParameters(0.85,0.99,1.5));


        quantifierSetForTrapezoidalFunction.put("Almost none", new FunctionParameters(0.0,0.0,0.05, 0.2));
        quantifierSetForTrapezoidalFunction.put("Some", new FunctionParameters(0.12,0.22,0.35, 0.4));
        quantifierSetForTrapezoidalFunction.put("About half", new FunctionParameters(0.35,0.45, 0.55,0.65));
        quantifierSetForTrapezoidalFunction.put("Many", new FunctionParameters(0.6,0.7,0.85, 0.9));
        quantifierSetForTrapezoidalFunction.put("Almost all", new FunctionParameters(0.85,0.99,1.0, 1.0));
    }


    @Override
    public Map<String, FunctionParameters> getSetForTriangularFunction() {
        return quantifierSetForTriangularFunction;
    }

    @Override
    public Map<String, FunctionParameters> getSetForTrapezoidalFunction() {
        return quantifierSetForTrapezoidalFunction;
    }
}
