package data.enums;

public enum ValueAttribute {

    VERY_CHEAP, CHEAP, AVERAGE, EXPENSIVE, VERY_EXPENSIVE;
    // 0-100k, 100k-900k, 900k-7M, 7M-50M, 50M-200M

    public static ValueAttribute valueOf(Double value) {
        if(value>50000000){
            return VERY_EXPENSIVE;
        } else if (value>7000000){
            return EXPENSIVE;
        } else if (value>900000){
            return AVERAGE;
        } else if (value>100000){
            return CHEAP;
        }
        return VERY_CHEAP;
    }

    private static Double minVal = 0.0;
    private static Double maxVal = 200000000.0;

}
