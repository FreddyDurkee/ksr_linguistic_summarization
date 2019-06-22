package data.Sets;

import data.FunctionParameters;
import data.Set;

import java.util.HashMap;
import java.util.Map;
//TODO: REMOVE
public class ValueSet implements Set {
    private Map<String, FunctionParameters> triangularFunction = new HashMap<>();
    private Map<String, FunctionParameters> trapezoidalFunction = new HashMap<>();

    public ValueSet() {
        triangularFunction.put("cheap", new FunctionParameters(0, 0, 90000));
        triangularFunction.put("young", new FunctionParameters(75000, 5000000, 7000000));
        triangularFunction.put("expensive", new FunctionParameters(6500000, 35000000, 50000000));
        triangularFunction.put("very expensive", new FunctionParameters(45000000, 200000000, 200000000));

        trapezoidalFunction.put("cheap", new FunctionParameters(0, 0, 10000, 90000));
        trapezoidalFunction.put("young", new FunctionParameters(75000, 3000000, 5000000, 7000000));
        trapezoidalFunction.put("expensive", new FunctionParameters(6500000, 35000000, 45000000, 50000000));
        trapezoidalFunction.put("very expensive", new FunctionParameters(45000000, 100000000, 200000000, 200000000));
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
