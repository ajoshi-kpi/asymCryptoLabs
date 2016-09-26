package generators.impl.lehmer;

import generators.Generator;

import static util.numberhelpers.NumberConverter.getNumberFromBinaryString;

public class LehmerHigh extends LehmerGenerator implements Generator {

    public LehmerHigh(int initialValue) {
        this.currentValue = initialValue;
    }

    @Override
    public int nextValue() {
        long value = super.nextGeneratorValue();
        return getHighBites(value, 8);
    }

    private int getHighBites(long value, int bitesNumber) {
        String binaryString = Long.toBinaryString(value);
        binaryString = binaryString.substring(0, bitesNumber);
        return getNumberFromBinaryString(binaryString);
    }
}
