package data.enums;

import data.AttributeSet;
import data.FunctionParameters;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum ValueAttribute implements EnumAttributes, AttributeSet {

    VERY_CHEAP, CHEAP, AVERAGE, EXPENSIVE, VERY_EXPENSIVE;
    // 0-100k, 100k-900k, 900k-7M, 7M-50M, 50M-200M

    public static ValueAttribute valueOf(Double value) {
        if (value > 50000000) {
            return VERY_EXPENSIVE;
        } else if (value > 7000000) {
            return EXPENSIVE;
        } else if (value > 900000) {
            return AVERAGE;
        } else if (value > 100000) {
            return CHEAP;
        }
        return VERY_CHEAP;
    }

    private static Double minVal = 0.0;
    private static Double maxVal = 200000000.0;

    @Override
    public Map<EnumAttributes, FunctionParameters> getSetForTriangularFunction() {
        Map<EnumAttributes, FunctionParameters> sftf = new HashMap<>();
//        sftf.put(HEAVY, new FunctionParameters(95.0, 110.0, 125.0));
//        sftf.put(SEMI_HEAVY, new FunctionParameters(102.5, 95.0, 87.5));
//        sftf.put(AVERAGE, new FunctionParameters(95.0, 80.0, 65.0));
//        sftf.put(WELTERWEIGHT, new FunctionParameters(72.5, 65.0, 57.5));
//        sftf.put(LIGHT, new FunctionParameters(65.0, 50.0, 35.0));
        return sftf;
    }

    @Override
    public Map<EnumAttributes, FunctionParameters> getSetForTrapezoidalFunction() {
        Map<EnumAttributes, FunctionParameters> sftf = new HashMap<>();
//        sftf.put(HEAVY, new FunctionParameters(95.0, 105.0, 115.0, 125.0));
//        sftf.put(SEMI_HEAVY, new FunctionParameters(87.5,92.5,97.5,102.5));
//        sftf.put(AVERAGE, new FunctionParameters(65.0,75.0,85.0,95.0));
//        sftf.put(WELTERWEIGHT, new FunctionParameters(57.5,62.5,67.5,72.5));
//        sftf.put(LIGHT, new FunctionParameters(35.0,45.0,55.0,65.0));
        return sftf;
    }

}
