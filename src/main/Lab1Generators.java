package main;

import generators.Generator;
import util.outputhelpers.FileHelper;
import util.outputhelpers.OutputHelper;

import java.io.IOException;

public class Lab1Generators implements Runnable {

    private final Generator generator;
    private final OutputHelper outputHelper;
    private final int rounds;

    public Lab1Generators(Generator generator, OutputHelper outputHelper, int rounds) {
        this.generator = generator;
        this.outputHelper = outputHelper;
        this.rounds = rounds;
    }

    public Lab1Generators(Generator generator, int rounds) {
        this.generator = generator;
        this.rounds = rounds;
        String[] fullClassName = generator.getClass().getName().split("\\.");
        this.outputHelper = new FileHelper(fullClassName[fullClassName.length - 1] + ".txt");
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < rounds; i++) {
            outputHelper.write(generator.nextValue());
            outputHelper.newLine();
        }
        try {
            outputHelper.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) + " ms");
    }
}
