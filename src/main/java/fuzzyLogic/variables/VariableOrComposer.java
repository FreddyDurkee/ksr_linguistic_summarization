package fuzzyLogic.variables;

import java.util.ArrayList;
import java.util.List;

public class VariableOrComposer implements LinguisticVariable {

    private final LinguisticVariable variable1;
    private final Variable variable;

    VariableOrComposer(Variable variable, LinguisticVariable variable1) {
        this.variable = variable;
        this.variable1 = variable1;
    }

    @Override
    public List<Double> getMembershipDegrees() {
        List<Double> degrees = variable.getMembershipDegrees();
        List<Double> degrees1 = variable1.getMembershipDegrees();
        ArrayList<Double> myList = new ArrayList<>();
        for(int i=0; i<degrees.size(); i++){
           myList.add(Math.max(degrees.get(i),degrees1.get(i)));
        }
        return myList;
    }

    @Override
    public LinguisticVariable and(LinguisticVariable variable) {
        return null;
    }

    @Override
    public LinguisticVariable or(LinguisticVariable variable) {
        return null;
    }

    @Override
    public int dimensions() {
        return variable.dimensions() + variable1.dimensions();
    }

    @Override
    public double getIn() {
        return variable.getIn() * variable1.getIn();
    }

    @Override
    public String getName() {
        return variable.getName()+" or " +variable1.getName();
    }

    @Override
    public double getR() {
        return variable.getR() * variable1.getR();
    }

    @Override
    public double getCardinality() {
        return getMembershipDegrees().stream().mapToDouble(a -> a).sum();
    }

    @Override
    public double getT8Cardinality() {
        return variable.getT8Cardinality() * variable1.getT8Cardinality();
    }
}
