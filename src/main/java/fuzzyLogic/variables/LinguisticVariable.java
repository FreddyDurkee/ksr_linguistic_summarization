package fuzzyLogic.variables;

import data.FootballerRepository;
import fuzzyLogic.Attribute;
import fuzzyLogic.functions.Function;

import java.util.List;


public interface LinguisticVariable {

    static LinguisticVariable of(String name, Function membershipFunction, Attribute attribute){
        return new Variable(name,membershipFunction,attribute);
    }


    List<Double> getMembershipDegrees();
    LinguisticVariable and(LinguisticVariable variable);
    LinguisticVariable or(LinguisticVariable variable);

    int dimensions();
    double getIn();
    String getName();

    double getR();

    double getCardinality();

    double getT8Cardinality();

    double getClm();

    void fit(FootballerRepository repository);
}
