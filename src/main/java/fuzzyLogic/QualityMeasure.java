package fuzzyLogic;

import fuzzyLogic.variables.LinguisticVariable;
import lombok.Data;

import java.util.List;

public class QualityMeasure {
    protected Quantifier quantifier;
    protected LinguisticVariable summarizer;

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
        T10,
        T11
    }

    public double getT1() {
        double cardinality = summarizer.getCardinality();
        int setSize = summarizer.getMembershipDegrees().size();
        return quantifier.getMembershipDegree(cardinality / setSize);
    }

    public double getT2() {
        double imprecision = summarizer.getIn();
        return 1 - Math.pow(imprecision, 1.0 / summarizer.dimensions());
    }

    public double getT3() {
        List<Double> membershipDegrees = summarizer.getMembershipDegrees();
        double sum = membershipDegrees.parallelStream().mapToDouble(a -> a).map(a-> a>0?1:0).sum();
        return sum / membershipDegrees.size();
    }

    public double getT4() {
        double r = summarizer.getR();
        return Math.abs(r - getT3());
    }

    public double getT5() {
        return 2 * Math.pow(0.5, summarizer.dimensions());
    }

    public double getT6() {
        return 1 - quantifier.getSupp();
    }

    public double getT7() {
        return 1 - quantifier.getClm();
    }

    public double getT8() {
        return 1 - Math.pow(summarizer.getT8Cardinality(), 1.0 / summarizer.dimensions());
    }

    public double getT9() {
        return Double.NaN;
    }

    public double getT10() {
        return Double.NaN;
    }

    public double getT11() {
        return Double.NaN;
    }

}
