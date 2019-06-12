package Gui;

import FuzzyLogic.LinguisticSummarizer;
import FuzzyLogic.functions.Function;
import FuzzyLogic.functions.TriangularFunction;

public class Application {
    public void main() {
        Function triangeAgeFun = new TriangularFunction(27, 30, 33);
        Function triangeAbout4Fun = new TriangularFunction(3, 4, 4);
        

        LinguisticSummarizer linguisticSummarizer = new LinguisticSummarizer();
    }
}
