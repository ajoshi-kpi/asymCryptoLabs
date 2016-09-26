package generators.impl.bmgenerator;


import generators.Generator;

import java.math.BigInteger;

/**
 * Created by ajoshi on 12-Sep-16.
 */
public class BMBitGenerator extends BMGenerator implements Generator {
    public BMBitGenerator(BigInteger currentState) {
        super(currentState);
    }


    @Override
    public int nextValue() {
        currentState = super.nextValue(currentState);
        if(currentState.compareTo(P.subtract(BigInteger.ONE).divide(BigInteger.valueOf(2))) > 0) {
            return 0;
        }
        return 1;
    }
}
