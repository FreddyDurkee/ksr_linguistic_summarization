package fuzzyLogic.functions;

public class TrapezoidalFunction implements  Function{
    private double a, b, c, d;

    public TrapezoidalFunction(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public double getMembership(double x) {
        checkParameters();
        if (x >= b && x <= c) return 1.0;
        if (x > a && x < b) return (x - a) / (b - a);
        if (x > c && x < d) return (d - x) / (d - c);

        return 0.0;
    }

    @Override
    public double getSupp() {
        return d-a;
    }

    @Override
    public double getArea() {
        return 0.5 * ((c-b) + (d-a));
    }

    private void checkParameters() {
        if(a > b){
            throw new IllegalArgumentException("A must be smaller than B");
        }
        if(b > c){
            throw new IllegalArgumentException("B must be smaller than C");
        }
        if(c > d){
            throw new IllegalArgumentException("C must be smaller than D");
        }
    }
}
