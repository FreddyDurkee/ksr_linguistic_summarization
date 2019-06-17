package data;

import java.util.HashMap;
import java.util.Map;

public class AgeAttrConfig {
    private static Map<String, FunctionParameters> quantifierSetForTriangularFunction = new HashMap<>();
    private static Map<String, FunctionParameters> quantifierSetForTrapezoidalFunction = new HashMap<>();

    static {
        quantifierSetForTriangularFunction.put("very young", new FunctionParameters(10,12,15));
        quantifierSetForTriangularFunction.put("young", new FunctionParameters(14,17,25));
        quantifierSetForTriangularFunction.put("average", new FunctionParameters(24,29,32));
        quantifierSetForTriangularFunction.put("old", new FunctionParameters(29,38,50));


        quantifierSetForTrapezoidalFunction.put("very young", new FunctionParameters(10,12,14,15));
        quantifierSetForTrapezoidalFunction.put("young", new FunctionParameters(14,16,20,25));
        quantifierSetForTrapezoidalFunction.put("average", new FunctionParameters(24,26,29,32));
        quantifierSetForTrapezoidalFunction.put("old", new FunctionParameters(29,35,100,100));

    }



    public static Map<String, FunctionParameters> getTriangular() {
        return quantifierSetForTriangularFunction;
    }

    public  static Map<String, FunctionParameters> getTrapezoidal() {
        return quantifierSetForTrapezoidalFunction;
    }
}
