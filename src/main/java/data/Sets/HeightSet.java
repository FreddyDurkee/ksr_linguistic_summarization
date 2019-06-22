package data.Sets;

import data.FunctionParameters;
import data.Set;

import java.util.HashMap;
import java.util.Map;
//TODO: REMOVE
public class HeightSet implements Set {
    private Map<String, FunctionParameters> triangularFunction = new HashMap<>();
    private Map<String, FunctionParameters> trapezoidalFunction = new HashMap<>();

    public HeightSet() {
        triangularFunction.put("very high", new FunctionParameters(178, 210, 210));
        triangularFunction.put("high", new FunctionParameters(165, 175, 185));
        triangularFunction.put("average", new FunctionParameters(160, 168, 175));
        triangularFunction.put("low", new FunctionParameters(140, 150, 163));

        trapezoidalFunction.put("very high", new FunctionParameters(178, 190, 210, 210));
        triangularFunction.put("high", new FunctionParameters(165, 175, 180, 185));
        triangularFunction.put("average", new FunctionParameters(160, 168, 172, 175));
        triangularFunction.put("low", new FunctionParameters(140, 145, 155, 163));
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
