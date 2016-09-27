package tests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajoshi on 26-Sep-16.
 */
public class BytesUniformityTest extends AbstractTest {

    private final int R;

    public BytesUniformityTest(List<Integer> BYTES, double ALPHA, int R) {
        super(BYTES, ALPHA, 255 * (R - 1));
        this.R = R;
    }

    @Override
    protected double calculateXi() {
        final int m = BYTES.size() / R;
        double xi = 0.0;
        for (int i = 0; i < 255; i++) {
            for (List<Integer> segment : getSegments()) {
                double currentXi = Math.pow(countOccurences(segment, i), 2.0) / (countOccurences(BYTES, i));
                xi += currentXi;
            }
        }
        return BYTES.size() * (xi / m - 1);
    }

    @Override
    public boolean test() {
        System.out.println("BytesUniformityTest: ");
        System.out.println("Xi = " + calculateXi());
        System.out.println("Xi(default) = " + calculateDefaultXi());
        return calculateXi() <= calculateDefaultXi();
    }

    private List<List<Integer>> getSegments() {
        List<List<Integer>> segments = new ArrayList<>();
        int bytesSize = BYTES.size();
        for (int i = 0; i < R; i++) {
            segments.add(BYTES.subList(i, i + bytesSize / R));
        }
        return segments;
    }

    private int countOccurences(List<Integer> bytes, int byteToFind) {
        int count = 0;
        for (Integer currentByte : bytes) {
            if(currentByte == byteToFind) {
                count++;
            }
        }
        return count;
    }
}
