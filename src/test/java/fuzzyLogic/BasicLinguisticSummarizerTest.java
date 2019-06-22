package fuzzyLogic;

import data.Footballer;
import data.FootballerRepository;
import fuzzyLogic.functions.Function;
import fuzzyLogic.functions.TriangularFunction;
import fuzzyLogic.variables.LinguisticVariable;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BasicLinguisticSummarizerTest {

    static FootballerRepository repository = new FootballerRepository();
    static Quantifier quantifier;
    static LinguisticVariable summarizer;



    @BeforeClass
    public static void setUpClass(){
        List<Footballer> data = new ArrayList<>();
        data.add(new Footballer(1,"Iniesta",34,86,21500000,170.18,68.04,67,55,58,84,79));
        data.add(new Footballer(2,"G. Morris",34,63,150000,182.88,69.85,43,30,63,55,56));
        data.add(new Footballer(3,"D. ukasik",27,69,875000,177.8,73.03,51,74,71,72,68));
        data.add(new Footballer(4,"T. Haye",23,71,975000,177.8,73.94,63,40,60,72,75));
        data.add(new Footballer(5,"J. Bijlow",20,82,3900000,190.5,73.03,43,30,71,30,32));
        data.add(new Footballer(6,"K. Sessa",17,80,400000,175.26,69.85,68,49,40,77,76));
        data.add(new Footballer(7,"A. Arregui",25,69,675000,175.26,73.94,69,82,69,69,68));
        repository.loadFromList(data);

        Function sumMembershipFun = new TriangularFunction(14, 17, 25);
        summarizer = LinguisticVariable.of(" young ", sumMembershipFun, Attribute.AGE);
        summarizer.fit(repository);

        Function quantifierMembershipFun = new TriangularFunction(0.12, 0.25, 0.4);
        quantifier = new Quantifier("Some ", quantifierMembershipFun);
    }


    @Test
    public void calculateT1Measure() {
        // Given
        CompoundSummarizer linguisticSummarizer = new CompoundSummarizer("test sentence", summarizer, quantifier);

        // When
        Double T1 = linguisticSummarizer.getT1();

        // Then
        Double expectedT1 = 0.8809;
        assertEquals(expectedT1, T1, 0.0001);
    }

    @Test
    public void calculateT2Measure() {
        // Given
        LinguisticSummarizer linguisticSummarizer = new CompoundSummarizer("test sentence", summarizer, quantifier);

        // When
        Double T2 = ((CompoundSummarizer) linguisticSummarizer).getT2();

        // Then
        Double expectedT2 = 0.89;
        assertEquals(expectedT2, T2, 0.0001);
    }

    @Test
    public void calculateT3Measure() {
        // Given
        LinguisticSummarizer linguisticSummarizer = new CompoundSummarizer("test sentence", summarizer, quantifier);

        // When
        Double T3 = ((CompoundSummarizer) linguisticSummarizer).getT3();

        // Then
        Double expectedT3 = 1.0*3/7;
        assertEquals(expectedT3, T3, 0.0001);
    }

    @Test
    public void calculateT4Measure() {
        // Given
        LinguisticSummarizer linguisticSummarizer = new CompoundSummarizer("test sentence", summarizer, quantifier);

        // When
        Double T4 = ((CompoundSummarizer) linguisticSummarizer).getT4();

        // Then
        Double expectedT4 = 0.0;
        assertEquals(expectedT4, T4, 0.0001);
    }

    @Test
    public void calculateT5Measure() {
        // Given
        LinguisticSummarizer linguisticSummarizer = new CompoundSummarizer("test sentence", summarizer, quantifier);

        // When
        Double T5 = ((CompoundSummarizer) linguisticSummarizer).getT5();

        // Then
        Double expectedT5 = 1.0;
        assertEquals(expectedT5, T5, 0.0001);
    }

    @Test
    public void calculateT6Measure() {
        // Given
        LinguisticSummarizer linguisticSummarizer = new CompoundSummarizer("test sentence", summarizer, quantifier);

        // When
        Double T6 = ((CompoundSummarizer) linguisticSummarizer).getT6();

        // Then
        Double expectedT6 = 0.72;
        assertEquals(expectedT6, T6, 0.0001);
    }

    @Test
    public void calculateT7Measure() {
        // Given
        LinguisticSummarizer linguisticSummarizer = new CompoundSummarizer("test sentence", summarizer, quantifier);

        // When
        Double T7 = ((CompoundSummarizer) linguisticSummarizer).getT7();

        // Then
        Double expectedT7 = 0.86;
        assertEquals(expectedT7, T7, 0.0001);
    }

    @Test
    public void calculateT8Measure() {
        // Given
        LinguisticSummarizer linguisticSummarizer = new CompoundSummarizer("test sentence", summarizer, quantifier);

        // When
        Double T8 = ((CompoundSummarizer) linguisticSummarizer).getT8();

        // Then
        Double expectedT8 = 0.945;
        assertEquals(expectedT8, T8, 0.0001);
    }

    @Test
    public void calculateT9Measure() {
        // Given
        LinguisticSummarizer linguisticSummarizer = new CompoundSummarizer("test sentence", summarizer, quantifier);

        // When
        Double T9 = ((CompoundSummarizer) linguisticSummarizer).getT9();

        // Then
        Double expectedT9 = 0.0;
        assertEquals(expectedT9, T9, 0.0001);
    }

    @Test
    public void calculateT10Measure() {
        // Given
        LinguisticSummarizer linguisticSummarizer = new CompoundSummarizer("test sentence", summarizer, quantifier);

        // When
        Double T10 = ((CompoundSummarizer) linguisticSummarizer).getT10();

        // Then
        Double expectedT10 = 0.0;
        assertEquals(expectedT10, T10, 0.0001);
    }

    @Test
    public void calculateT11Measure() {
        // Given
        LinguisticSummarizer linguisticSummarizer = new CompoundSummarizer("test sentence", summarizer, quantifier);

        // When
        Double T11 = ((CompoundSummarizer) linguisticSummarizer).getT11();

        // Then
        Double expectedT11 = 2.0;
        assertEquals(expectedT11, T11, 0.0001);
    }
}
