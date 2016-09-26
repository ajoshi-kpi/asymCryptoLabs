package util.inputhelpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListFileInputHelper {
    private BufferedReader reader;
    private final String FOLDER_NAME = "outputs/";

    public ListFileInputHelper(String filename) {
        try {
            reader = new BufferedReader(new FileReader(FOLDER_NAME + filename));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> readFromFile() {
        List<Integer> result = new ArrayList<>();
        try {
            String currentRow = reader.readLine();
            while (currentRow != null) {
                result.add(Integer.parseInt(currentRow));
                currentRow = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
