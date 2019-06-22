package fuzzyLogic;

import lombok.Getter;

public enum Attribute {
    AGE(0, 100),
    HEIGHT(0, 210),
    POTENTIAL(0, 100),
    VALUE(0, 200000000),
    WEIGHT(0, 120);

    @Getter
    private final double min;
    @Getter
    private final double max;

    Attribute(double min, double max) {
        this.min = min;
        this.max = max;
    }
}
