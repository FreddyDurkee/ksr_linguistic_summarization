package FuzzyLogic;

import java.util.List;

public class FuzzySet {
    public static double cardinality(List<Double> values){
        double sum = 0;
        for(Double value : values)
            sum += value;
        return sum;
    }


}
