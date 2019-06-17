package data.enums;

import data.AttributeSet;
import data.FunctionParameters;
import data.Set;
import lombok.Getter;
import org.w3c.dom.Attr;

import javax.print.attribute.Attribute;
import java.util.HashMap;
import java.util.Map;

@Getter
public enum AgeAttribute implements EnumAttributes, AttributeSet {

    VERY_OLD, OLD, AVERAGE, YOUNG, VERY_YOUNG;
    // 100-45, 45-35, 35-25, 20-25 , 0-20

    public static AgeAttribute valueOf(Double value) {
        if(value>45){
            return VERY_OLD;
        } else if(value>35){
            return OLD;
        } else if (value>25){
            return AVERAGE;
        } else if (value>20){
            return YOUNG;
        }
        return VERY_YOUNG;
    }

    private static Double minVal = 0.0;
    private static Double maxVal = 100.0;

    @Override
    public Map<EnumAttributes, FunctionParameters> getSetForTriangularFunction() {
        Map<EnumAttributes, FunctionParameters> sftf = new HashMap<>();
        sftf.put(VERY_OLD, new FunctionParameters(40.0, 70.0, 100.0));
        sftf.put(OLD, new FunctionParameters(30.0, 45.0, 60.0));
        sftf.put(AVERAGE, new FunctionParameters(25.0, 30.0, 35.0));
        sftf.put(YOUNG, new FunctionParameters(15.0, 22.5, 30.0));
        sftf.put(VERY_YOUNG, new FunctionParameters(0.0, 10.0, 20.0));
        return sftf;
    }

    @Override
    public Map<EnumAttributes, FunctionParameters> getSetForTrapezoidalFunction() {
        Map<EnumAttributes, FunctionParameters> sftf = new HashMap<>();
        sftf.put(VERY_OLD, new FunctionParameters(40.0, 60.0, 80.0, 100.0));
        sftf.put(OLD, new FunctionParameters(30.0, 35.0, 45.0, 60.0));
        sftf.put(AVERAGE, new FunctionParameters(25.0, 27.5, 32.5, 35.0));
        sftf.put(YOUNG, new FunctionParameters(15.0, 18.75, 26.25, 30.0));
        sftf.put(VERY_YOUNG, new FunctionParameters(0.0, 5.0, 15.0, 20.0));
        return sftf;
    }
}
