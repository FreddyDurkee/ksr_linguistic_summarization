package fuzzyLogic.functions;


public class TriangularFunction implements Function{
    private double a, b, c;

    public TriangularFunction(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getMembership(double x) {
        checkParameters();

        if (Math.abs(x - b) < .00001) return 1;
        if (x > a && x < b) return (x - a) / (b - a);
        if (x > b && x < c) return (c - x) / (c - b);
        return 0;
    }

    @Override
    public double getSupp() {
        return c-a;
    }

    @Override
    public double getArea() {
        return 0.5 * getSupp();
    }

    private void checkParameters() {
        if(a > b){
            throw new IllegalArgumentException("A must be smaller than B");
        }
        if(b > c){
            throw new IllegalArgumentException("B must be smaller than C");
        }
    }
}
