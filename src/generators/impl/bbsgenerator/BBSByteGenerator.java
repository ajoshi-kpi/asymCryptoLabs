package generators.impl.bbsgenerator;

import generators.Generator;

import java.math.BigInteger;

/**
 * Created by ajoshi on 12-Sep-16.
 */
public class BBSByteGenerator extends BBSGenerator implements Generator {

    public BBSByteGenerator(BigInteger initialState) {
        super(initialState);
    }

    @Override
    public int nextValue() {
        currentState = super.nextValue(currentState);
        return currentState.mod(new BigInteger("256")).intValue();
    }
}
