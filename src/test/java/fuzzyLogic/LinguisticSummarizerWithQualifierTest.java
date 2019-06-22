package fuzzyLogic;

import data.Footballer;
import data.FootballerRepository;
import fuzzyLogic.functions.Function;
import fuzzyLogic.functions.TrapezoidalFunction;
import fuzzyLogic.functions.TriangularFunction;
import fuzzyLogic.variables.LinguisticVariable;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LinguisticSummarizerWithQualifierTest {

    static FootballerRepository repository = new FootballerRepository();
    static Quantifier quantifier;
    static LinguisticVariable summarizer, qualifier;



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

        Function sumMembershipFun1 = new TriangularFunction(14, 17, 25);
        summarizer = LinguisticVariable.of(" young ", sumMembershipFun1, Attribute.AGE);
        summarizer.fit(repository);

        Function sumMembershipFun2 = new TrapezoidalFunction(165, 175, 180, 185);
        qualifier = LinguisticVariable.of(" high ", sumMembershipFun2, Attribute.HEIGHT);
        qualifier.fit(repository);

        Function quantifierMembershipFun = new TriangularFunction(0.12, 0.25, 0.4);
        quantifier = new Quantifier("Some ", quantifierMembershipFun);
    }


    @Test
    public void calculateT1Measure() {
        // Given
        String sentence = quantifier.getName() + " footballers being / having " + qualifier.getName() + " are / have " + summarizer.getName();
        QualifiedSummarizer linguisticSummarizer = new QualifiedSummarizer(sentence,summarizer,quantifier,qualifier);

        // When
        Double T1 = linguisticSummarizer.getT1();

        // Then
        Double expectedT1 = (0.4 - 0.25293)/(0.4-0.25);
        assertEquals(expectedT1, T1, 0.0001);
    }

    @Test
    public void calculateT2Measure() {
        // Given
        String sentence = qualifier.getName() + " footballers being / having " + qualifier.getName() + " are / have " + qualifier.getName();
        QualifiedSummarizer linguisticSummarizer = new QualifiedSummarizer(sentence,summarizer,quantifier,qualifier);

        // When
        Double T2 = linguisticSummarizer.getT2();

        // Then
        Double expectedT2 = 0.89;
        assertEquals(expectedT2, T2, 0.0001);
    }

    @Test
    public void calculateT3Measure() {
        // Given
        String sentence = qualifier.getName() + " footballers being / having " + qualifier.getName() + " are / have " + qualifier.getName();
        QualifiedSummarizer linguisticSummarizer = new QualifiedSummarizer(sentence,summarizer,quantifier,qualifier);

        // When
        Double T3 = linguisticSummarizer.getT3();

        // Then
        Double expectedT3 = 2.0/6;
        assertEquals(expectedT3, T3, 0.0001);
    }

    @Test
    public void calculateT4Measure() {
        // Given
        String sentence = qualifier.getName() + " footballers being / having " + qualifier.getName() + " are / have " + qualifier.getName();
        QualifiedSummarizer linguisticSummarizer = new QualifiedSummarizer(sentence,summarizer,quantifier,qualifier);

        // When
        Double T4 = linguisticSummarizer.getT4();

        // Then
        Double expectedT4 = Math.abs((3.0/7) - 2.0/6);
        assertEquals(expectedT4, T4, 0.0001);
    }

    @Test
    public void calculateT5Measure() {
        // Given
        String sentence = qualifier.getName() + " footballers being / having " + qualifier.getName() + " are / have " + qualifier.getName();
        QualifiedSummarizer linguisticSummarizer = new QualifiedSummarizer(sentence,summarizer,quantifier,qualifier);

        // When
        Double T5 = linguisticSummarizer.getT5();

        // Then
        Double expectedT5 = 1.0;
        assertEquals(expectedT5, T5, 0.0001);
    }

    @Test
    public void calculateT6Measure() {
        // Given
        String sentence = qualifier.getName() + " footballers being / having " + qualifier.getName() + " are / have " + qualifier.getName();
        QualifiedSummarizer linguisticSummarizer = new QualifiedSummarizer(sentence,summarizer,quantifier,qualifier);

        // When
        Double T6 = linguisticSummarizer.getT6();

        // Then
        Double expectedT6 = 0.72;
        assertEquals(expectedT6, T6, 0.0001);
    }

    @Test
    public void calculateT7Measure() {
        // Given
        String sentence = qualifier.getName() + " footballers being / having " + qualifier.getName() + " are / have " + qualifier.getName();
        QualifiedSummarizer linguisticSummarizer = new QualifiedSummarizer(sentence,summarizer,quantifier,qualifier);

        // When
        Double T7 = linguisticSummarizer.getT7();

        // Then
        Double expectedT7 = 0.86;
        assertEquals(expectedT7, T7, 0.0001);
    }

    @Test
    public void calculateT8Measure() {
        // Given
        String sentence = qualifier.getName() + " footballers being / having " + qualifier.getName() + " are / have " + qualifier.getName();
        QualifiedSummarizer linguisticSummarizer = new QualifiedSummarizer(sentence,summarizer,quantifier,qualifier);

        // When
        Double T8 = linguisticSummarizer.getT8();

        // Then
        Double expectedT8 = 0.945;
        assertEquals(expectedT8, T8, 0.0001);
    }

    @Test
    public void calculateT9Measure() {
        // Given
        String sentence = qualifier.getName() + " footballers being / having " + qualifier.getName() + " are / have " + qualifier.getName();
        QualifiedSummarizer linguisticSummarizer = new QualifiedSummarizer(sentence,summarizer,quantifier,qualifier);

        // When
        Double T9 = linguisticSummarizer.getT9();

        // Then
        Double expectedT9 = 0.9047;
        assertEquals(expectedT9, T9, 0.0001);
    }

    @Test
    public void calculateT10Measure() {
        // Given
        String sentence = qualifier.getName() + " footballers being / having " + qualifier.getName() + " are / have " + qualifier.getName();
        QualifiedSummarizer linguisticSummarizer = new QualifiedSummarizer(sentence,summarizer,quantifier,qualifier);

        // When
        Double T10 = linguisticSummarizer.getT10();

        // Then
        Double expectedT10 = 0.9404;
        assertEquals(expectedT10, T10, 0.0001);
    }

    @Test
    public void calculateT11Measure() {
        // Given
        String sentence = qualifier.getName() + " footballers being / having " + qualifier.getName() + " are / have " + qualifier.getName();
        QualifiedSummarizer linguisticSummarizer = new QualifiedSummarizer(sentence,summarizer,quantifier,qualifier);

        // When
        Double T11 = linguisticSummarizer.getT11();

        // Then
        Double expectedT11 = 1.0;
        assertEquals(expectedT11, T11, 0.0001);
    }
}
