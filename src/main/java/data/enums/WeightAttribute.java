package data.enums;

import data.AttributeSet;
import data.FunctionParameters;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum WeightAttribute implements EnumAttributes, AttributeSet {

    HEAVY, SEMI_HEAVY, AVERAGE, WELTERWEIGHT, LIGHT;
    // 120-100, 100-90, 70-90, 60-70, 40-60

    public static WeightAttribute valueOf(Double value) {
        if (value > 100) {
            return HEAVY;
        } else if (value > 90) {
            return SEMI_HEAVY;
        } else if (value > 70) {
            return AVERAGE;
        } else if (value > 60) {
            return WELTERWEIGHT;
        }
        return LIGHT;
    }

    private static Double minVal = 35.0;
    private static Double maxVal = 125.0;

    @Override
    public Map<EnumAttributes, FunctionParameters> getSetForTriangularFunction() {
        Map<EnumAttributes, FunctionParameters> sftf = new HashMap<>();
        sftf.put(HEAVY, new FunctionParameters(95.0, 110.0, 125.0));
        sftf.put(SEMI_HEAVY, new FunctionParameters(87.5, 95.0, 102.5));
        sftf.put(AVERAGE, new FunctionParameters(65.0, 80.0, 95.0));
        sftf.put(WELTERWEIGHT, new FunctionParameters(57.5, 65.0, 72.5));
        sftf.put(LIGHT, new FunctionParameters(35.0, 50.0, 65.0));
        return sftf;
    }

    @Override
    public Map<EnumAttributes, FunctionParameters> getSetForTrapezoidalFunction() {
        Map<EnumAttributes, FunctionParameters> sftf = new HashMap<>();
        sftf.put(HEAVY, new FunctionParameters(95.0, 105.0, 115.0, 125.0));
        sftf.put(SEMI_HEAVY, new FunctionParameters(87.5, 92.5, 97.5, 102.5));
        sftf.put(AVERAGE, new FunctionParameters(65.0, 75.0, 85.0, 95.0));
        sftf.put(WELTERWEIGHT, new FunctionParameters(57.5, 62.5, 67.5, 72.5));
        sftf.put(LIGHT, new FunctionParameters(35.0, 45.0, 55.0, 65.0));
        return sftf;
    }

}
