package fuzzyLogic;

import fuzzyLogic.variables.LinguisticVariable;

public class LinguisticSummarizer {
    private Quantifier quantifier;
    private LinguisticVariable summarizer;
    private QualityMeasure qualityMeasure;

    public LinguisticSummarizer(Quantifier quantifier, LinguisticVariable summarizer) {
        this.quantifier = quantifier;
        this.summarizer = summarizer;
        qualityMeasure = new QualityMeasure(quantifier, summarizer);
    }

    public double getQualityOfLinguisticSummarization(QualityMeasure.Measure measure){
        switch (measure) {
            case T1:
                return qualityMeasure.getT1();
            case T2:
                return qualityMeasure.getT2();
            case T3:
                return qualityMeasure.getT3();
            case T4:
                return qualityMeasure.getT4();
            case T5:
                return qualityMeasure.getT5();
            case T6:
                return qualityMeasure.getT6();
            case T7:
                return qualityMeasure.getT7();
            case T8:
                return qualityMeasure.getT8();
            case T9:
                return qualityMeasure.getT9();
            case T10:
                return qualityMeasure.getT10();
            default:
                throw new IllegalArgumentException(measure.toString() + "is not a member of Measure enum in QualityMeasure class.");
        }
    }
    public String getSentence(QualityMeasure.Measure measure){
        double quality = getQualityOfLinguisticSummarization(measure);
        return quantifier.getName() + " are/have " + summarizer.getName() + " T[ " + quality + " ]";
    }

}
