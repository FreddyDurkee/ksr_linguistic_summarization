package fuzzyLogic;

import data.FootballerRepository;

import java.util.List;

public enum Attribute {
    //TODO: Fix values
    AGE(0, 100),
    HEIGHT(0, 210),
    POTENTIAL(0, 100),
    VALUE(0, 200000000),
    WEIGHT(0, 120);

    private static final FootballerRepository repository = new FootballerRepository();

    static {
        repository.loadFromCSV(Thread.currentThread().getContextClassLoader().getResource("footballers.csv").getPath());
    }

    private final double min;
    private final double max;

    Attribute(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public List<Double> getAllValues() {
        switch (this) {
            case AGE:
                return repository.getAllAges();
            case VALUE:
                return repository.getAllValues();
            case HEIGHT:
                return repository.getAllHeights();
            case WEIGHT:
                return repository.getAllWeights();
            case POTENTIAL:
                return repository.getAllPotentials();
            default:
                throw new IllegalArgumentException("Unknown Attribute type.");
        }
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}
