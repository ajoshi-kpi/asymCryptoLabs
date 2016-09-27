package generators.impl.lehmer;


public abstract class LehmerGenerator {
    protected final long M = (long) Math.pow(2, 32);
    protected final long A = (long) (Math.pow(2, 16) + 1);
    protected final long C = 119;
    protected long currentValue;

    protected long nextGeneratorValue() {
        currentValue = (A * currentValue + C) % M;
        return currentValue;
    }
}
