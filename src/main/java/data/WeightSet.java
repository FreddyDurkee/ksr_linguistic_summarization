package data;

import java.util.HashMap;
import java.util.Map;

public class WeightSet implements  Set{
    private Map<String, FunctionParameters> quantifierSetForTriangularFunction = new HashMap<>();
    private Map<String, FunctionParameters> quantifierSetForTrapezoidalFunction = new HashMap<>();

    public WeightSet() {
        quantifierSetForTriangularFunction.put("heavy", new FunctionParameters(80,120,200));
        quantifierSetForTriangularFunction.put("average", new FunctionParameters(65,75,95));
        quantifierSetForTriangularFunction.put("welterweight", new FunctionParameters(50,60,68));
        quantifierSetForTriangularFunction.put("light", new FunctionParameters(40,40,52));


        quantifierSetForTrapezoidalFunction.put("heavy", new FunctionParameters(80,100,120,200));
        quantifierSetForTrapezoidalFunction.put("average", new FunctionParameters(65,75,80,95));
        quantifierSetForTrapezoidalFunction.put("welterweight", new FunctionParameters(50,60,65,68));
        quantifierSetForTrapezoidalFunction.put("light", new FunctionParameters(40,40,45,52));

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
