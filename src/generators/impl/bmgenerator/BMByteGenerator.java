package generators.impl.bmgenerator;


import generators.Generator;

import java.math.BigInteger;

/**
 * Created by ajoshi on 12-Sep-16.
 */
public class BMByteGenerator extends BMGenerator implements Generator {

    public BMByteGenerator(BigInteger currentState) {
        super(currentState);
    }

    @Override
    public int nextValue() {
        currentState = super.nextValue(currentState);
        BigInteger BI256 = new BigInteger(String.valueOf(256));
        for (int i = 0; i < 256; i++) {
            BigInteger current = new BigInteger(String.valueOf(i));
            if((currentState.compareTo(current.multiply(P.subtract(BigInteger.ONE)).divide(BI256)) > 0) &&
                    (currentState.compareTo(current.add(BigInteger.ONE).multiply(P.subtract(BigInteger.ONE)).divide(BI256)) < 0)) {
                return i;
            }
        }
        return 0;
    }
}
