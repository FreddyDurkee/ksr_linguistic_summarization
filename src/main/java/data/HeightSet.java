package data;

import java.util.HashMap;
import java.util.Map;

public class HeightSet implements  Set{
    private Map<String, FunctionParameters> quantifierSetForTriangularFunction = new HashMap<>();
    private Map<String, FunctionParameters> quantifierSetForTrapezoidalFunction = new HashMap<>();

    public HeightSet() {
        quantifierSetForTriangularFunction.put("very high", new FunctionParameters(178,210,210));
        quantifierSetForTriangularFunction.put("high", new FunctionParameters(165,175,185));
        quantifierSetForTriangularFunction.put("average", new FunctionParameters(160,168,175));
        quantifierSetForTriangularFunction.put("low", new FunctionParameters(140,150,163));

        quantifierSetForTrapezoidalFunction.put("very high", new FunctionParameters(178,190,210,210));
        quantifierSetForTriangularFunction.put("high", new FunctionParameters(165,175,180,185));
        quantifierSetForTriangularFunction.put("average", new FunctionParameters(160,168,172,175));
        quantifierSetForTriangularFunction.put("low", new FunctionParameters(140, 145, 155,163));
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
