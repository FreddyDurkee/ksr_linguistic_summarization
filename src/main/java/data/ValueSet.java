package data;

import java.util.HashMap;
import java.util.Map;

public class ValueSet implements  Set{
    private Map<String, FunctionParameters> quantifierSetForTriangularFunction = new HashMap<>();
    private Map<String, FunctionParameters> quantifierSetForTrapezoidalFunction = new HashMap<>();

    public ValueSet() {
        quantifierSetForTriangularFunction.put("cheap", new FunctionParameters(0,0,90000));
        quantifierSetForTriangularFunction.put("young", new FunctionParameters(75000,5000000,7000000));
        quantifierSetForTriangularFunction.put("expensive", new FunctionParameters(6500000,35000000,50000000));
        quantifierSetForTriangularFunction.put("very expensive", new FunctionParameters(45000000,200000000,200000000));


        quantifierSetForTrapezoidalFunction.put("cheap", new FunctionParameters(0,0, 10000, 90000));
        quantifierSetForTrapezoidalFunction.put("young", new FunctionParameters(75000,3000000, 5000000,7000000));
        quantifierSetForTrapezoidalFunction.put("expensive", new FunctionParameters(6500000,35000000, 45000000, 50000000));
        quantifierSetForTrapezoidalFunction.put("very expensive", new FunctionParameters(45000000,100000000,200000000,200000000));

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
