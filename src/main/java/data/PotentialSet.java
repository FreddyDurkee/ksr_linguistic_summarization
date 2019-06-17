package data;

import java.util.HashMap;
import java.util.Map;

public class PotentialSet implements  Set{
    private Map<String, FunctionParameters> quantifierSetForTriangularFunction = new HashMap<>();
    private Map<String, FunctionParameters> quantifierSetForTrapezoidalFunction = new HashMap<>();

    public PotentialSet() {
        quantifierSetForTriangularFunction.put("legendary", new FunctionParameters(90,100,100));
        quantifierSetForTriangularFunction.put("professional", new FunctionParameters(65,85,95));
        quantifierSetForTriangularFunction.put("novice", new FunctionParameters(40,50,70));
        quantifierSetForTriangularFunction.put("old", new FunctionParameters(0,0,50));


        quantifierSetForTrapezoidalFunction.put("legendary", new FunctionParameters(90,100,100));
        quantifierSetForTrapezoidalFunction.put("professional", new FunctionParameters(65,79, 89,95));
        quantifierSetForTrapezoidalFunction.put("novice", new FunctionParameters(35,40, 50,70));
        quantifierSetForTrapezoidalFunction.put("old", new FunctionParameters(0,0,25,50));

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
