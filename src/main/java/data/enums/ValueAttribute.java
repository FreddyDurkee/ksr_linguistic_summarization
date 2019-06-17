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
        sftf.put(VERY_CHEAP, new FunctionParameters(0.0, 50000.0, 100000.0));
        sftf.put(CHEAP, new FunctionParameters(100000.0, 500000.0, 1100000.0));
        sftf.put(AVERAGE, new FunctionParameters(900000.0, 3812500.0, 8525000.0));
        sftf.put(EXPENSIVE, new FunctionParameters(7000000.0, 26875000.0, 60750000.0));
        sftf.put(VERY_EXPENSIVE, new FunctionParameters(50000000.0, 75000000.0, 200000000.0));
        return sftf;
    }

    @Override
    public Map<EnumAttributes, FunctionParameters> getSetForTrapezoidalFunction() {
        Map<EnumAttributes, FunctionParameters> sftf = new HashMap<>();
        sftf.put(VERY_CHEAP, new FunctionParameters(0.0, 33333.0, 66666.0, 100000.0));
        sftf.put(CHEAP, new FunctionParameters(100000.0, 433333.0, 766666.0, 1100000.0));
        sftf.put(AVERAGE, new FunctionParameters(900000.0, 3441666.0, 5983333.0, 8525000.0));
        sftf.put(EXPENSIVE, new FunctionParameters(7000000.0, 24916666.0, 42833333.0, 60750000.0));
        sftf.put(VERY_EXPENSIVE, new FunctionParameters(50000000.0, 100000000.0, 150000000.0, 200000000.0));
        return sftf;
    }

}
