package data.enums;

import data.AttributeSet;
import data.FunctionParameters;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum HeightAttribute implements EnumAttributes, AttributeSet {

    VERY_HIGH, HIGH, AVERAGE, LOW, VERY_LOW;
    // 210-178, 178-170, 170-165, 165-157, 157-100

    public static HeightAttribute valueOf(Double value) {
        if(value>178){
            return VERY_HIGH;
        } else if (value>170){
            return HIGH;
        } else if (value>165){
            return AVERAGE;
        } else if (value>157){
            return LOW;
        }
        return VERY_LOW;
    }

    private static Double minVal = 100.0;
    private static Double maxVal = 220.0;

    @Override
    public Map<EnumAttributes, FunctionParameters> getSetForTriangularFunction() {
        Map<EnumAttributes, FunctionParameters> sftf = new HashMap<>();
        sftf.put(VERY_HIGH, new FunctionParameters(220.0,194.0,170.0));
        sftf.put(HIGH, new FunctionParameters(180.0,174.0,168.0));
        sftf.put(AVERAGE, new FunctionParameters(171.25,167.5,163.75));
        sftf.put(LOW, new FunctionParameters(167.0,161.0,155.0));
        sftf.put(VERY_LOW, new FunctionParameters(157.0,128.5,100.0));
        return sftf;
    }

    @Override
    public Map<EnumAttributes, FunctionParameters> getSetForTrapezoidalFunction() {
        Map<EnumAttributes, FunctionParameters> sftf = new HashMap<>();
        sftf.put(VERY_HIGH, new FunctionParameters(218.0,202.0,186.0,170.0));
        sftf.put(HIGH, new FunctionParameters(180.0,176.0,172.0,168.0));
        sftf.put(AVERAGE, new FunctionParameters(171.25,168.75,166.25, 163.75));
        sftf.put(LOW, new FunctionParameters(167.0,163.0,159.0,155.0));
        sftf.put(VERY_LOW, new FunctionParameters(157.0,138.0,119.0,100.0));
        return sftf;
    }

}
