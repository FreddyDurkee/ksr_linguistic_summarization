package Data;

import lombok.Data;

@Data
public class FunctionParameters {
    private Double a;
    private Double b;
    private Double c;
    private Double d;

    public FunctionParameters(Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public FunctionParameters(Double a, Double b, Double c, Double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
}
