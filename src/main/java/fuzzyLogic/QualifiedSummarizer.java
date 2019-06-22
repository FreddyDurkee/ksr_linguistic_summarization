package fuzzyLogic;

import fuzzyLogic.variables.LinguisticVariable;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class QualifiedSummarizer implements LinguisticSummarizer{

    private String sentence;
    private LinguisticVariable summarizer;
    private Quantifier quantifier;
    private final LinguisticVariable qualifier;

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

    public QualityMeasure getMeasurements(){
        QualityMeasure qualityMeasure = new QualityMeasure();
        qualityMeasure.setSentence(sentence);
        qualityMeasure.setT1(getT1());
        qualityMeasure.setT2(getT2());
        qualityMeasure.setT3(getT3());
        qualityMeasure.setT4(getT4());
        qualityMeasure.setT5(getT5());
        qualityMeasure.setT6(getT6());
        qualityMeasure.setT7(getT7());
        qualityMeasure.setT8(getT8());
        qualityMeasure.setT9(getT9());
        qualityMeasure.setT10(getT10());
        qualityMeasure.setT11(getT11());
        return qualityMeasure;
    }
}
