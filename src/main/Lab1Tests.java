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
        List<Integer> bytes = fileHelper.readFromFile();
        System.out.println(new BytesEquabilityTest(bytes, 0.01).test());
        System.out.println(new BytesIndependenceTest(bytes, 0.01).test());
        System.out.println(new BytesUniformityTest(bytes, 0.01, 100).test());
    }
}
