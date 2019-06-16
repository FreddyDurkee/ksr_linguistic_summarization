package data.enums;

import lombok.Getter;

@Getter
public enum AgeAttribute implements EnumAttributes{

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

}
