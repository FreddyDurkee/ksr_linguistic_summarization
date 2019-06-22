package data.Sets;

import data.FunctionParameters;
import data.Set;

import java.util.HashMap;
import java.util.Map;
//TODO: REMOVE
public class WeightSet implements Set {
    private Map<String, FunctionParameters> triangularFunction = new HashMap<>();
    private Map<String, FunctionParameters> trapezoidalFunction = new HashMap<>();

    public WeightSet() {
        triangularFunction.put("heavy", new FunctionParameters(80, 120, 200));
        triangularFunction.put("average", new FunctionParameters(65, 75, 95));
        triangularFunction.put("welterweight", new FunctionParameters(50, 60, 68));
        triangularFunction.put("light", new FunctionParameters(40, 40, 52));

        trapezoidalFunction.put("heavy", new FunctionParameters(80, 100, 120, 200));
        trapezoidalFunction.put("average", new FunctionParameters(65, 75, 80, 95));
        trapezoidalFunction.put("welterweight", new FunctionParameters(50, 60, 65, 68));
        trapezoidalFunction.put("light", new FunctionParameters(40, 40, 45, 52));
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
