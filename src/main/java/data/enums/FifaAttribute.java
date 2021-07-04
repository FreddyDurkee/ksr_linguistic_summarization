package data.enums;

import data.AttributeSet;
import data.FunctionParameters;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum FifaAttribute implements EnumAttributes, AttributeSet {

    LEGENDARY, WORLD_CLASS, PROFESSIONAL, NOVICE, AMATEUR, BEGINNER;
    // 100-95, 95-85, 85-70, 70-60, 60-50, 50-0

    public static FifaAttribute valueOf(Double value) {
        if (value > 95) {
            return LEGENDARY;
        } else if (value > 85) {
            return WORLD_CLASS;
        } else if (value > 70) {
            return PROFESSIONAL;
        } else if (value > 60) {
            return NOVICE;
        } else if (value > 50) {
            return AMATEUR;
        }
        return BEGINNER;
    }

    private static Double minVal = 0.0;
    private static Double maxVal = 100.0;

    @Override
    public Map<EnumAttributes, FunctionParameters> getSetForTriangularFunction() {
        Map<EnumAttributes, FunctionParameters> sftf = new HashMap<>();
        sftf.put(LEGENDARY, new FunctionParameters(92.5, 97.5, 100.0));
        sftf.put(WORLD_CLASS, new FunctionParameters(82.5, 90.0, 97.5));
        sftf.put(PROFESSIONAL, new FunctionParameters(70.0, 77.5, 85.0));
        sftf.put(NOVICE, new FunctionParameters(55.0, 65.0, 75.0));
        sftf.put(AMATEUR, new FunctionParameters(50.0, 55.0, 60.0));
        sftf.put(BEGINNER, new FunctionParameters(0.0, 25.0, 50.0));
        return sftf;
    }

    @Override
    public Map<EnumAttributes, FunctionParameters> getSetForTrapezoidalFunction() {
        Map<EnumAttributes, FunctionParameters> sftf = new HashMap<>();
        sftf.put(LEGENDARY, new FunctionParameters(92.5, 9.5, 97.5, 100.0));
        sftf.put(WORLD_CLASS, new FunctionParameters(82.5, 87.5, 92.5, 97.5));
        sftf.put(PROFESSIONAL, new FunctionParameters(70.0, 75.0, 80.0, 85.0));
        sftf.put(NOVICE, new FunctionParameters(55.0, 63.0, 67.0, 75.0));
        sftf.put(AMATEUR, new FunctionParameters(50.0, 53.0, 57.0, 60.0));
        sftf.put(BEGINNER, new FunctionParameters(0.0, 18.0, 32.0, 50.0));
        return sftf;
    }

}
