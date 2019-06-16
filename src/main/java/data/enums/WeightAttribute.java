package data.enums;

import lombok.Getter;

@Getter
public enum WeightAttribute {

    HEAVY, SEMI_HEAVY, AVERAGE, WELTERWEIGHT, LIGHT;
    // 120-100, 100-90, 70-90, 60-70, 40-60

    public static WeightAttribute valueOf(Double value) {
        if(value>100){
            return HEAVY;
        } else if (value>90){
            return SEMI_HEAVY;
        } else if (value>70){
            return AVERAGE;
        } else if (value>60){
            return WELTERWEIGHT;
        }
        return LIGHT;
    }

    private static Double minVal = 40.0;
    private static Double maxVal = 120.0;
}
