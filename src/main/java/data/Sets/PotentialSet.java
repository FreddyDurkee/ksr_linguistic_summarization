package data.Sets;

import data.FunctionParameters;
import data.Set;

import java.util.HashMap;
import java.util.Map;
//TODO: REMOVE
public class PotentialSet implements Set {
    private Map<String, FunctionParameters> triangularFunction = new HashMap<>();
    private Map<String, FunctionParameters> trapezoidalFunction = new HashMap<>();

    public PotentialSet() {
        triangularFunction.put("legendary", new FunctionParameters(90, 100, 100));
        triangularFunction.put("professional", new FunctionParameters(65, 85, 95));
        triangularFunction.put("novice", new FunctionParameters(40, 50, 70));
        triangularFunction.put("old", new FunctionParameters(0, 0, 50));

        trapezoidalFunction.put("legendary", new FunctionParameters(90, 100, 100));
        trapezoidalFunction.put("professional", new FunctionParameters(65, 79, 89, 95));
        trapezoidalFunction.put("novice", new FunctionParameters(35, 40, 50, 70));
        trapezoidalFunction.put("old", new FunctionParameters(0, 0, 25, 50));
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
