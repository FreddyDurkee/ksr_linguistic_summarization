package gui;

import fuzzyLogic.*;
import fuzzyLogic.functions.Function;
import fuzzyLogic.functions.TriangularFunction;
import fuzzyLogic.variables.LinguisticVariable;


public class Application {
    public static void main(String[] args) {
        Function triangeAgeFun = new TriangularFunction(27, 30, 33);
        Function triangeAbout4Fun = new TriangularFunction(0.0, 0.5, 0.75);

        Quantifier quantifier = new Quantifier("About 2", triangeAbout4Fun);
        LinguisticVariable summarizer = LinguisticVariable.of("age about 30", triangeAgeFun, new Attribute());


        LinguisticSummarizer linguisticSummarizer = new LinguisticSummarizer(quantifier, summarizer);
        System.out.println(linguisticSummarizer.getQualityOfLinguisticSummarization(QualityMeasure.Measure.T1));
    }
}
