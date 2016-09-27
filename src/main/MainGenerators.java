package main;

import generators.impl.bbsgenerator.BBSByteGenerator;
import generators.impl.bmgenerator.BMByteGenerator;
import generators.impl.defaultgenerator.DefaultGenerator;
import generators.impl.geffe.GeffeGenerator;
import generators.impl.lehmer.LehmerHigh;
import generators.impl.lehmer.LehmerLow;
import generators.impl.librarian.LibrarianGenerator;
import generators.impl.linear.L20Generator;
import generators.impl.linear.L89Generator;
import generators.impl.wolfram.WolframGenerator;

import java.math.BigInteger;

public class MainGenerators {
    private final static String L20_INITIAL_STATE = "10110101001010010101";
    private final static String L89_INITIAL_STATE = "10011011110111001110001111100000100000100001111100001110101001110001101110101010010000101";

    private final static String L1_GEFFE_INITIAL_STATE = "10010010110";
    private final static String L2_GEFFE_INITIAL_STATE = "100101101";
    private final static String L3_GEFFE_INITIAL_STATE = "0010011010";

    private final static int[] WOLFRAM_INITIAL_STATE = new int[]{1,1,0,0,0,0,1,0,0,1,1,0,0,0,1,1,0,0,1,1,1,0,0,0,1,0,0,1,1,1,0,0};
    public static void main(String[] args) {

//        new Thread(new Lab1Generators(new DefaultGenerator(), 1000000)).start();
        new Thread(new Lab1Generators(new LehmerLow(20061996), 1000000)).start();
//        new Thread(new Lab1Generators(new LehmerHigh(20061996), 1000000)).start();
//        new Thread(new Lab1Generators(new L20Generator(L20_INITIAL_STATE), 1000000)).start();
//        new Thread(new Lab1Generators(new L89Generator(L89_INITIAL_STATE), 1000000)).start();
//        new Thread(new Lab1Generators(new LibrarianGenerator("lib.txt"), 1000000)).start();
//        new Thread(new Lab1Generators(new GeffeGenerator(
//                L1_GEFFE_INITIAL_STATE,
//                L2_GEFFE_INITIAL_STATE,
//                L3_GEFFE_INITIAL_STATE), 1000000)).start();
//        new Thread(new Lab1Generators(new WolframGenerator(WOLFRAM_INITIAL_STATE), 1000000)).start();
//        new Thread(new Lab1Generators(new BBSByteGenerator(BigInteger.valueOf(20061996)), 1000000)).start();
//        new Thread(new Lab1Generators(new BMByteGenerator(BigInteger.valueOf(20061996)), 1000000)).start();

    }
}