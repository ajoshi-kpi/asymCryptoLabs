package generators.impl.bmgenerator;

import java.math.BigInteger;

/**
 * Created by ajoshi on 12-Sep-16.
 */
public class BMGenerator {

    protected final BigInteger P = new BigInteger("CEA42B987C44FA642D80AD9F51F10457690DEF10C83D0BC1BCEE12FC3B6093E3", 16);
    protected final BigInteger A = new BigInteger("5B88C41246790891C095E2878880342E88C79974303BD0400B090FE38A688356", 16);
    protected BigInteger currentState;

    protected BMGenerator(BigInteger currentState) {
        this.currentState = currentState;
    }

    protected BigInteger nextValue(BigInteger currentState) {
        return A.modPow(currentState, P);
    }
}
