package fuzzyLogic.variables;

import data.FootballerRepository;
import fuzzyLogic.Attribute;
import fuzzyLogic.functions.Function;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class Variable implements LinguisticVariable{

    @Getter
    private String name;
    private Function membershipFunction;
    @Getter
    private Attribute attribute;
    private List<Double> membershipDegress;


    public Variable(String name, Function membershipFunction, Attribute attribute) {
        this.name = name;
        this.membershipFunction = membershipFunction;
        this.attribute = attribute;
    }

    public List<Double> getMembershipDegrees(){
        return membershipDegress;
    }

    public LinguisticVariable and(LinguisticVariable variable) {
        return new VariableAndComposer(this,variable);
    }

    public LinguisticVariable or(LinguisticVariable variable) {
        return new VariableOrComposer(this,variable);
    }

    @Override
    public int dimensions() {
        return 1;
    }

    @Override
    public double getIn() {
        return membershipFunction.getSupp() / getSizeUniverseOfDiscourse();
    }

    @Override
    public double getR() {
        double r = getMembershipDegrees().stream().mapToDouble(a->a).filter(a->a>0).count();
        return r / getMembershipDegrees().size();
    }

    double getSizeUniverseOfDiscourse(){
        return attribute.getMax() - attribute.getMin();
    }

    @Override
    public double getCardinality() {
        return getMembershipDegrees().stream().mapToDouble(a -> a).sum();
    }

    @Override
    public double getT8Cardinality() {
        return getClm() / getSizeUniverseOfDiscourse();
    }

    @Override
    public double getClm(){
        return  membershipFunction.getArea();
    }

    @Override
    public void fit(FootballerRepository repository) {
        membershipDegress = new ArrayList<>();
        for(Double value : repository.get(attribute)){
            membershipDegress.add(membershipFunction.getMembership(value));
        }
    }

}
