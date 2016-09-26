package tests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BytesEquabilityTest extends AbstractTest {

    public BytesEquabilityTest(List<Integer> BYTES, double ALPHA) {
        super(BYTES, ALPHA, 255);
    }

    @Override
    public boolean test() {
        return calculateXi() <= calculateDefaultXi();
    }

    @Override
    protected double calculateXi() {
        double xi = 0.0;
        final int N = BYTES.size() / 256;
        Map<Integer, Integer> frequencies = getFrequencies(BYTES);
        for (Integer currentByte : frequencies.keySet()) {
            xi += (Math.pow(frequencies.get(currentByte) - N, 2.0)) / N;
        }
        return xi;
    }

    private Map<Integer, Integer> getFrequencies(List<Integer> bytes) {
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (Integer currentByte : bytes) {
            if(frequencies.get(currentByte) == null) {
                frequencies.put(currentByte, 1);
            } else {
                frequencies.put(currentByte, frequencies.get(currentByte) + 1);
            }
        }
        return frequencies;
    }
}
