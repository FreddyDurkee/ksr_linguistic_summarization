package fuzzyLogic;

public class LinguisticSummarizer {
    private final String sentence;
    private QualityMeasure qualityMeasure;

    public LinguisticSummarizer(String sentence, QualityMeasure measure) {
        this.sentence = sentence;
        this.qualityMeasure = measure;
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
            case T11:
                return qualityMeasure.getT11();
            default:
                throw new IllegalArgumentException(measure.toString() + "is not a member of Measure enum in QualityMeasure class.");
        }
    }
    public Result getMeasurements(){
        Result result = new Result();
        result.setSentence(sentence);
        result.setT1(getQualityOfLinguisticSummarization(QualityMeasure.Measure.T1));
        result.setT2(getQualityOfLinguisticSummarization(QualityMeasure.Measure.T2));
        result.setT3(getQualityOfLinguisticSummarization(QualityMeasure.Measure.T3));
        result.setT4(getQualityOfLinguisticSummarization(QualityMeasure.Measure.T4));
        result.setT5(getQualityOfLinguisticSummarization(QualityMeasure.Measure.T5));
        result.setT6(getQualityOfLinguisticSummarization(QualityMeasure.Measure.T6));
        result.setT7(getQualityOfLinguisticSummarization(QualityMeasure.Measure.T7));
        result.setT8(getQualityOfLinguisticSummarization(QualityMeasure.Measure.T8));
        result.setT9(getQualityOfLinguisticSummarization(QualityMeasure.Measure.T9));
        result.setT10(getQualityOfLinguisticSummarization(QualityMeasure.Measure.T10));
        result.setT11(getQualityOfLinguisticSummarization(QualityMeasure.Measure.T11));
        return result;
    }

}
