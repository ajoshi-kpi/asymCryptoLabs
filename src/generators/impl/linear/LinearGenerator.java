package generators.impl.linear;

import java.util.List;

public class LinearGenerator {

    private List<Integer> mask;

    public LinearGenerator(List<Integer> mask) {
        this.mask = mask;
    }

    public int nextValue(String currentState) {
        int nextBit = 0;
        for (Integer currentIndex : mask) {
            nextBit += Integer.parseInt(String.valueOf(currentState.charAt(currentIndex - 1)));
        }
        nextBit %= 2;
        return nextBit;
    }
}
