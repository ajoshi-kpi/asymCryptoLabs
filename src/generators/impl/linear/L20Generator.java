package generators.impl.linear;

import generators.Generator;

import java.util.Arrays;

public class L20Generator implements Generator {
    private LinearGenerator linearGenerator;
    private String currentState;

    public L20Generator(String initialState) {
        this.currentState = initialState;
        linearGenerator = new LinearGenerator(Arrays.asList(3, 5, 9, 20));
    }

    @Override
    public int nextValue() {
        int nextBit = linearGenerator.nextValue(currentState);
        int result = Integer.parseInt(String.valueOf(currentState.charAt(0)));
        currentState = currentState.substring(1, currentState.length()) + nextBit;
        return result;
    }
}
