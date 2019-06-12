package FuzzyLogic;

import java.util.List;

public class QualityMeasure {
    private LinguisticVariable quantifier;
    private LinguisticVariable summarizer;

    public QualityMeasure(LinguisticVariable quantifier, LinguisticVariable summarizer) {
        this.quantifier = quantifier;
        this.summarizer = summarizer;
    }

    public enum Measure {
        T1,
        T2,
        T3,
        T4,
        T5,
        T6,
        T7,
        T8,
        T9,
        T10
    }

    public static double getT1(List<Double> membershipDegrees){
        Double cardinality = FuzzySet.cardinality(membershipDegrees);
        Integer setSize = membershipDegrees.size();
        return cardinality/setSize;
    }


}
