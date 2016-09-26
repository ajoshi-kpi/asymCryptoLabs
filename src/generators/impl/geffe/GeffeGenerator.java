package generators.impl.geffe;

import generators.Generator;
import generators.impl.linear.LinearGenerator;

import java.util.Arrays;

public class GeffeGenerator implements Generator {

    private LinearGenerator l11;
    private String l11currentState;
    private LinearGenerator l9;
    private String l9currentState;
    private LinearGenerator l10;
    private String l10currentState;

    public GeffeGenerator(String l11initial, String l9initial, String l10initial) {
        l11 = new LinearGenerator(Arrays.asList(1, 3));
        this.l11currentState = l11initial;
        l9 = new LinearGenerator(Arrays.asList(1, 2, 4, 5));
        this.l9currentState = l9initial;
        l10 = new LinearGenerator(Arrays.asList(1, 4));
        this.l10currentState = l10initial;
    }

    @Override
    public int nextValue() {
        int x11 = l11.nextValue(l11currentState);
        l11currentState = l11currentState.substring(1, l11currentState.length()) + x11;
        int y9 = l9.nextValue(l9currentState);
        l9currentState = l9currentState.substring(1, l9currentState.length()) + y9;
        int s10 = l10.nextValue(l10currentState);
        l10currentState = l10currentState.substring(1, l10currentState.length()) + s10;
        return (s10 * x11) ^ (1 ^ s10) * y9;
    }
}
