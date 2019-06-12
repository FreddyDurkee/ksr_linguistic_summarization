package FuzzyLogic;

public class LinguisticSummarizer {
    private LinguisticVariable quantifier;
    private LinguisticVariable summarizer;
    private FuzzySet fuzzySet;

    public LinguisticSummarizer(LinguisticVariable quantifier, LinguisticVariable summarizer) {
        this.quantifier = quantifier;
        this.summarizer = summarizer;
    }


    public void setQuantifier(LinguisticVariable quantifier){
        this.quantifier = quantifier;
    }

    public void setSummarizer(LinguisticVariable summarizer){
        this.summarizer = summarizer;
    }

    public double getQualityOfLinguisticSummarization(QualityMeasure.Measure measure){
        switch (measure) {
            case T1:
                return QualityMeasure.getT1(quantifier.getMembershipDegrees());
            default:
                throw new IllegalArgumentException(measure.toString() + "is not a member of Measure enum in QualityMeasure class.");
        }
    }

}
