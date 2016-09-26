package generators.impl.lehmer;

import generators.Generator;

import static util.numberhelpers.NumberConverter.getNumberFromBinaryString;

public class LehmerLow extends LehmerGenerator implements Generator {

    public LehmerLow(int initialValue) {
        this.currentValue = initialValue;
    }

    public int nextValue() {
        long value = super.nextGeneratorValue();
        return getLowBites(value, 8);
    }

    private int getLowBites(long value, int bitesNumber) {
        String binaryString = Long.toBinaryString(value);
        binaryString = binaryString.substring(binaryString.length() - bitesNumber);
        return getNumberFromBinaryString(binaryString);
    }
}
