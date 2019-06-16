package data.enums;

import lombok.Getter;

@Getter
public enum HeightAttribute implements EnumAttributes {

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
    private static Double maxVal = 210.0;

}
