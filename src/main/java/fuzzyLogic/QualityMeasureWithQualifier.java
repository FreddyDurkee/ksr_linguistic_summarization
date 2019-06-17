package fuzzyLogic;

import fuzzyLogic.variables.LinguisticVariable;

import java.util.ArrayList;
import java.util.List;

public class QualityMeasureWithQualifier extends QualityMeasure {
    private final LinguisticVariable qualifier;

    public QualityMeasureWithQualifier(Quantifier quantifier, LinguisticVariable summarizer, LinguisticVariable qualifier) {
        super(quantifier, summarizer);
        this.qualifier = qualifier;
    }

    public double getT1() {
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < qualifier.getMembershipDegrees().size(); i++) {
            result.add(Math.min(summarizer.getMembershipDegrees().get(i), qualifier.getMembershipDegrees().get(i)));
        }
        double sum = result.parallelStream().mapToDouble(a -> a).sum();
        return quantifier.getMembershipDegree(sum / qualifier.getCardinality());
    }

    public double getT2() {
        double imprecision = summarizer.getIn();
        return 1 - Math.pow(imprecision, 1.0 / summarizer.dimensions());
    }

    public double getT3() {
        List<Double> result = new ArrayList<>();
        for (int i = 0; i < qualifier.getMembershipDegrees().size(); i++) {
            result.add(Math.min(summarizer.getMembershipDegrees().get(i), qualifier.getMembershipDegrees().get(i)));
        }
        double sum = result.parallelStream().mapToDouble(a -> a).map(a -> a > 0 ? 1 : 0).sum();
        double quali_sum = qualifier.getMembershipDegrees().parallelStream().mapToDouble(a -> a).map(a -> a > 0 ? 1 : 0).sum();
        return sum / quali_sum;
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
        double imprecision = qualifier.getIn();
        return 1 - imprecision;
    }

    public double getT10() {
        return 1 - qualifier.getT8Cardinality();
    }

    public double getT11() {
        return 2 * 0.5;
    }

}
