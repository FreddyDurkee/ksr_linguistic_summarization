package data.enums;

import lombok.Getter;

@Getter
public enum FifaAttribute implements EnumAttributes {

    LEGENDARY, WORLD_CLASS, PROFESSIONAL, NOVICE, AMATEUR, BEGINNER;
    // 100-95, 95-85, 85-70, 70-60, 60-50, 50-0

    public static FifaAttribute valueOf(Double value) {
        if(value>95){
            return LEGENDARY;
        } else if (value>85){
            return WORLD_CLASS;
        } else if (value>70){
            return PROFESSIONAL;
        } else if (value>60){
            return NOVICE;
        } else if (value>50){
            return AMATEUR;
        }
        return BEGINNER;
    }

    private static Double minVal = 0.0;
    private static Double maxVal = 100.0;

}
