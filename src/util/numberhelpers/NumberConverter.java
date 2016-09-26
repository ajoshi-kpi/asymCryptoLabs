package util.numberhelpers;

public class NumberConverter {
    public static int getNumberFromBinaryString(String binaryString) {
        int result = 0;
        for (int i = binaryString.length() - 1, j = 0; i >= 0; i--, j++) {
            result += Math.pow(2, j) * Integer.parseInt(String.valueOf(binaryString.charAt(i)));
        }
        return result;
    }
}
