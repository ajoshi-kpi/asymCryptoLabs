package tests;

import javafx.util.Pair;
import tests.util.Statistics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BytesIndependenceTest extends AbstractTest {

    public BytesIndependenceTest(List<Integer> BYTES, double ALPHA) {
        super(BYTES, ALPHA, 255 * 255);
    }

    @Override
    public boolean test() {
        return calculateXi() <= calculateDefaultXi();
    }

    @Override
    protected double calculateXi() {
        Statistics statistics = getStatistics(BYTES);
        double xi = 0.0;
        for (int i = 0; i < 255; i++) {
            for (int j = 0; j < 255; j++) {
                int pairFreq = statistics.getFrequencies().get(new Pair<>(i, j)) != null ?
                        statistics.getFrequencies().get(new Pair<>(i, j)) : 0;
                int firstPlaceFreq = statistics.getFirstPlaceFrequencies().get(i) != null ?
                        statistics.getFirstPlaceFrequencies().get(i) : 0;
                int secondByteFreq = statistics.getSecondPlaceFrequencies().get(j) != null ?
                        statistics.getSecondPlaceFrequencies().get(j) : 0;
                if (i != 0 && j != 0) {
                    xi += Math.pow(pairFreq, 2.0) / (firstPlaceFreq * secondByteFreq);
                }
            }
        }
        int n = BYTES.size() / 2;
        xi = n * (xi - 1);
        return xi;
    }

    private Statistics getStatistics(List<Integer> bytes) {
        Map<Pair<Integer, Integer>, Integer> frequencies = new HashMap<>();
        Map<Integer, Integer> firstPlaceFrequencies = new HashMap<>();
        Map<Integer, Integer> secondPlaceFrequencies = new HashMap<>();

        for (int i = 0; i < bytes.size(); i++) {
            if (i % 2 == 0) {
                Pair<Integer, Integer> currentPair = new Pair<>(bytes.get(i), bytes.get(i + 1));
                if (frequencies.get(currentPair) == null) {
                    frequencies.put(currentPair, 1);
                } else {
                    frequencies.put(currentPair, frequencies.get(currentPair) + 1);
                }

                if (firstPlaceFrequencies.get(bytes.get(i)) == null) {
                    firstPlaceFrequencies.put(bytes.get(i), 1);
                } else {
                    firstPlaceFrequencies.put(bytes.get(i), firstPlaceFrequencies.get(bytes.get(i)) + 1);
                }
            } else {
                if (secondPlaceFrequencies.get(bytes.get(i)) == null) {
                    secondPlaceFrequencies.put(bytes.get(i), 1);
                } else {
                    secondPlaceFrequencies.put(bytes.get(i), secondPlaceFrequencies.get(bytes.get(i)) + 1);
                }
            }
        }

        return new Statistics(frequencies, firstPlaceFrequencies, secondPlaceFrequencies);
    }
}
