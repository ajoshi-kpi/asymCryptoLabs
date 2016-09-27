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
        quantils.put(0.01, 2.32);
        quantils.put(0.05, 1.645); // TODO QUANTILE VALUE
        quantils.put(0.1, 1.26);
    }

    abstract protected double calculateXi();

    protected double calculateDefaultXi() {
        return Math.sqrt(2 * L) * quantils.get(ALPHA) + L;
    }
}
