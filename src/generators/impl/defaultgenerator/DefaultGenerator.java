package generators.impl.defaultgenerator;

import generators.Generator;

import java.util.Random;

public class DefaultGenerator implements Generator {
    private Random random = new Random();

    @Override
    public int nextValue() {
        return random.nextBoolean() ? 1 : 0;
    }
}
