package generators.impl.linear;

import generators.Generator;

import java.util.Arrays;

public class L89Generator implements Generator {
    private LinearGenerator linearGenerator;
    private String currentState;

    public L89Generator(String initialState) {
        this.currentState = initialState;
        linearGenerator = new LinearGenerator(Arrays.asList(38, 89));
    }


    @Override
    public int nextValue() {
        int nextBit = linearGenerator.nextValue(currentState);
        int result = Integer.parseInt(String.valueOf(currentState.charAt(0)));
        currentState = currentState.substring(1, currentState.length()) + nextBit;
        return result;
    }
}
