package main;

import tests.BytesEquabilityTest;
import tests.BytesIndependenceTest;
import tests.BytesUniformityTest;
import util.inputhelpers.ListFileInputHelper;

import java.util.List;

public class Lab1Tests implements Runnable {
    @Override
    public void run() {
        ListFileInputHelper fileHelper = new ListFileInputHelper("DefaultGenerator.txt");
        final double alpha = 0.01;
        final int r = 100;

        List<Integer> bytes = fileHelper.readFromFile();
        System.out.println(new BytesEquabilityTest(bytes, alpha).test());
        System.out.println(new BytesIndependenceTest(bytes, alpha).test());
        System.out.println(new BytesUniformityTest(bytes, alpha, r).test());
    }
}
