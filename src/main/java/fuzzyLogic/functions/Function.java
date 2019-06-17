package fuzzyLogic.functions;

public interface Function {

    enum FunctionType {
        TRIANGULAR,
        TRAPEZOIDAL
    }

    double getMembership(double x);

    double getSupp();

    double getArea();

    static Function of(FunctionType type, double a, double b, double c, double d) {
        switch (type) {
            case TRAPEZOIDAL:
                return new TrapezoidalFunction(a, b, c, d);
            case TRIANGULAR:
                return new TriangularFunction(a, b, c);
            default:
                throw new IllegalArgumentException("Unknown function");
        }
    }
}
