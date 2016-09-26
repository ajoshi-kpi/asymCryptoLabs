package util.outputhelpers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileHelper implements OutputHelper {

    private BufferedWriter writer;
    private final String FOLDER_NAME = "outputs/";

    public FileHelper(String filename) {
        try {
            writer = new BufferedWriter(new FileWriter(FOLDER_NAME + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(int value) {
        try {
            writer.write(String.valueOf(value));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void newLine() {
        try {
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
