package generators.impl.wolfram;

import generators.Generator;

public class WolframGenerator implements Generator {

    private int[] currentValue;

    public WolframGenerator(int[] intitialStates) {
        this.currentValue = intitialStates;
    }

    @Override
    public int nextValue() {
        currentValue = xor(cyclicLeftShift(currentValue), or(currentValue, cyclicRightShift(currentValue)));
        return currentValue[currentValue.length - 1];
    }

    private int[] cyclicLeftShift(int[] value) {
        int[] result = new int[value.length];
        for (int i = 0; i < value.length - 1; i++) {
            result[i] = value[i+1];
        }
        result[result.length - 1] = value[0];
        return result;
    }

    private int[] cyclicRightShift(int[] value) {
        int[] result = new int[value.length];
        for (int i = 1; i < value.length; i++) {
            result[i] = value[i-1];
        }
        result[0] = value[result.length - 1];
        return result;
    }

    private int[] or(int[] x, int[] y) {
        int[] result = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            result[i] = x[i] | y[i];
        }
        return result;
    }

    private int[] xor(int[]x, int []y) {
        int[] result = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            result[i] = x[i] ^ y[i];
        }
        return result;
    }
}
