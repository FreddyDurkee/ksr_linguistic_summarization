package fuzzyLogic;

public class LinguisticSummarizer {
    private Quantifier quantifier;
    private LinguisticVariable summarizer;
    private QualityMeasure qualityMeasure;

    public LinguisticSummarizer(Quantifier quantifier, LinguisticVariable summarizer) {
        this.quantifier = quantifier;
        this.summarizer = summarizer;
        qualityMeasure = new QualityMeasure(quantifier, summarizer);
    }


    public void setQuantifier(Quantifier quantifier){
        this.quantifier = quantifier;
    }

    public void setSummarizer(LinguisticVariable summarizer){
        this.summarizer = summarizer;
    }

    public double getQualityOfLinguisticSummarization(QualityMeasure.Measure measure){
        qualityMeasure.setQuantifier(quantifier);
        qualityMeasure.setSummarizer(summarizer);
        switch (measure) {
            case T1:
                return qualityMeasure.getT1();
            default:
                throw new IllegalArgumentException(measure.toString() + "is not a member of Measure enum in QualityMeasure class.");
        }
    }

}
