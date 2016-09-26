package main;

import util.inputhelpers.StringFileInputHelper;
import util.outputhelpers.FileHelper;
import util.numberhelpers.NumberConverter;

public class MainConverter {
    public static void main(String[] args) {
        StringFileInputHelper fileInputHelper = new StringFileInputHelper("WolframGenerator.txt");
        FileHelper fileHelper = new FileHelper("WolframGenerator.txt");
        String result = fileInputHelper.readFromFile();
        for (int i = 0; i < result.length() / 8; i++) {
            fileHelper.write(NumberConverter.getNumberFromBinaryString(result.substring(i, i + 8)));
            fileHelper.newLine();
        }
    }
}
