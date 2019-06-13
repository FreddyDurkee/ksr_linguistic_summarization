package FuzzyLogic;

import lombok.Data;

import java.util.List;

@Data
public class QualityMeasure {
    private Quantifier quantifier;
    private LinguisticVariable summarizer;

    public QualityMeasure(Quantifier quantifier, LinguisticVariable summarizer) {
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

    public double getT1(){
        List<Double> membershipDegrees = summarizer.getMembershipDegrees();
        Double cardinality = FuzzySet.cardinality(membershipDegrees);
        Integer setSize = membershipDegrees.size();
        return quantifier.getMembershipDegree(cardinality/setSize);
    }


}
