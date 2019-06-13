package FuzzyLogic;

import FuzzyLogic.functions.Function;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class Quantifier {
    @Getter
    private String name;
    private Function membershipFunction;

    public Quantifier(String name, Function membershipFunction) {
        this.name = name;
        this.membershipFunction = membershipFunction;
    }

    public Double getMembershipDegree(Double x) {
        return membershipFunction.getMembership(x);
    }
}
