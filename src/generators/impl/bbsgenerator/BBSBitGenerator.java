package generators.impl.bbsgenerator;

import generators.Generator;

import java.math.BigInteger;

/**
 * Created by ajoshi on 12-Sep-16.
 */
public class BBSBitGenerator extends BBSGenerator implements Generator {
    public BBSBitGenerator(BigInteger initialState) {
        super(initialState);
    }

    @Override
    public int nextValue() {
        currentState = super.nextValue(currentState);
        return currentState.mod(BigInteger.valueOf(2L)).intValue();
    }
}
