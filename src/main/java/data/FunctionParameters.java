package data;

import lombok.Data;

@Data
public class FunctionParameters {
    private double a;
    private double b;
    private double c;
    private double d;

    private String functionName;

    public FunctionParameters(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public FunctionParameters(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

}
