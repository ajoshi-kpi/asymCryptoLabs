package util.inputhelpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StringFileInputHelper {
    private BufferedReader reader;
    private final String FOLDER_NAME = "inputs/";

    public StringFileInputHelper(String filename) {
        try {
            reader = new BufferedReader(new FileReader(FOLDER_NAME + filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String readFromFile() {
        StringBuilder result = new StringBuilder();
        try {
            String currentRow = reader.readLine();
            while (currentRow != null) {
                result.append(currentRow);
                currentRow = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
