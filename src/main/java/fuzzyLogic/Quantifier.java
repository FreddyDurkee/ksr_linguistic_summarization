package fuzzyLogic;

import fuzzyLogic.functions.Function;
import lombok.Data;
import lombok.Getter;

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

    public double getSupp() {
        return membershipFunction.getSupp();
    }

    public double getClm() {
        return membershipFunction.getArea();
    }
}
