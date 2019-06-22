package data.Sets;

import data.FunctionParameters;
import data.Set;

import java.util.HashMap;
import java.util.Map;
//TODO: REMOVE
public class QuantifiersSet implements Set {
    private Map<String, FunctionParameters> triangularFunction = new HashMap<>();
    private Map<String, FunctionParameters> trapezoidalFunction = new HashMap<>();

    public QuantifiersSet() {
        triangularFunction.put("Almost none", new FunctionParameters(0.0, 0.0, 0.2));
        triangularFunction.put("Some", new FunctionParameters(0.12, 0.25, 0.4));
        triangularFunction.put("About half", new FunctionParameters(0.35, 0.5, 0.65));
        triangularFunction.put("Many", new FunctionParameters(0.6, 0.75, 0.9));
        triangularFunction.put("Almost all", new FunctionParameters(0.85, 0.99, 1.5));

        trapezoidalFunction.put("Almost none", new FunctionParameters(0.0, 0.0, 0.05, 0.2));
        trapezoidalFunction.put("Some", new FunctionParameters(0.12, 0.22, 0.35, 0.4));
        trapezoidalFunction.put("About half", new FunctionParameters(0.35, 0.45, 0.55, 0.65));
        trapezoidalFunction.put("Many", new FunctionParameters(0.6, 0.7, 0.85, 0.9));
        trapezoidalFunction.put("Almost all", new FunctionParameters(0.85, 0.99, 1.0, 1.0));
    }

    @Override
    public Map<String, FunctionParameters> getTriangular() {
        return triangularFunction;
    }

    @Override
    public Map<String, FunctionParameters> getTrapezoidal() {
        return trapezoidalFunction;
    }
}
