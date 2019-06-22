package fuzzyLogic;

import fuzzyLogic.variables.LinguisticVariable;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CompoundSummarizer implements LinguisticSummarizer {

    private String sentence;
    private LinguisticVariable summarizer;
    private Quantifier quantifier;

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
        return 0.0;
    }

    public double getT10() {
        return 0.0;
    }

    public double getT11() {
        return 2;
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
