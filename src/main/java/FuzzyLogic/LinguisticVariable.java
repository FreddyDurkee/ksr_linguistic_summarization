package FuzzyLogic;

import FuzzyLogic.functions.Function;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class LinguisticVariable {
    @Getter
    private String name;
    private Function membershipFunction;
    @Getter
    private  Attribute attribute;


    public LinguisticVariable(String name, Function membershipFunction, Attribute attribute) {
        this.name = name;
        this.membershipFunction = membershipFunction;
        this.attribute = attribute;
    }

    public List<Double> getMembershipDegrees(){
        List<Double> membershipDegress = new ArrayList<>();
        for(Double value : attribute.getAllValues()){
            membershipDegress.add(membershipFunction.getMembership(value));
        }
        return membershipDegress;
    }

}
