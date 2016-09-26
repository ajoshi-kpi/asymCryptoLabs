package tests.util;

import javafx.util.Pair;

import java.util.Map;

public class Statistics {
    private final Map<Pair<Integer, Integer>, Integer> frequencies;
    private final Map<Integer, Integer> firstPlaceFrequencies;
    private final Map<Integer, Integer> secondPlaceFrequencies;

    public Statistics(Map<Pair<Integer, Integer>, Integer> frequencies, Map<Integer, Integer> firstPlaceFrequencies, Map<Integer, Integer> secondPlaceFrequencies) {
        this.frequencies = frequencies;
        this.firstPlaceFrequencies = firstPlaceFrequencies;
        this.secondPlaceFrequencies = secondPlaceFrequencies;
    }

    public Map<Pair<Integer, Integer>, Integer> getFrequencies() {
        return frequencies;
    }

    public Map<Integer, Integer> getFirstPlaceFrequencies() {
        return firstPlaceFrequencies;
    }

    public Map<Integer, Integer> getSecondPlaceFrequencies() {
        return secondPlaceFrequencies;
    }
}
