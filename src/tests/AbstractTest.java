package tests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractTest implements Test {
    protected final List<Integer> BYTES;
    protected final double ALPHA;
    protected final int L;
    private Map<Double, Double> quantils = new HashMap<>();

    AbstractTest(List<Integer> BYTES, double ALPHA, int L) {
        initQuantils();
        this.BYTES = BYTES;
        this.ALPHA = ALPHA;
        this.L = L;
    }

    private void initQuantils() {
        quantils.put(0.01, 3.715);
        quantils.put(0.05, 3.315); // TODO QUANTILE VALUE
        quantils.put(0.1, 3.09);
    }

    abstract protected double calculateXi();

    protected double calculateDefaultXi() {
        return Math.sqrt(2 * L) * quantils.get(ALPHA) + L;
    }
}
