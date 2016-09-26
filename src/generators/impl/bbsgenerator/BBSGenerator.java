package generators.impl.bbsgenerator;

import java.math.BigInteger;

/**
 * Created by ajoshi on 12-Sep-16.
 */
public class BBSGenerator {
    protected final BigInteger P = new BigInteger("D5BBB96D30086EC484EBA3D7F9CAEB07", 16);
    protected final BigInteger Q = new BigInteger("425D2B9BFDB25B9CF6C416CC6E37B59C1F", 16);
    protected final BigInteger N;
    protected BigInteger currentState;

    protected BBSGenerator(BigInteger initialState) {
        this.currentState = initialState;
        N = P.multiply(Q);
    }

    protected BigInteger nextValue(BigInteger currentState) {
        return currentState.modPow(BigInteger.valueOf(2L), N);
    }
}
