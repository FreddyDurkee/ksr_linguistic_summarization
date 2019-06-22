package fuzzyLogic;

import lombok.Data;

@Data
public class QualityMeasure {
    private String sentence;
    private double T1;
    private double T2;
    private double T3;
    private double T4;
    private double T5;
    private double T6;
    private double T7;
    private double T8;
    private double T9;
    private double T10;
    private double T11;

    @Override
    public String toString() {
        return  sentence +
                " " + T1 +
                " " + T2 +
                " " + T3 +
                " " + T4 +
                " " + T5 +
                " " + T6 +
                " " + T7 +
                " " + T8 +
                " " + T9 +
                " " + T10 +
                " " + T11;
    }
}
