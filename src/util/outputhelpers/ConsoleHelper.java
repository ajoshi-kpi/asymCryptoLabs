package util.outputhelpers;

import java.io.IOException;

public class ConsoleHelper implements OutputHelper {

    public void write(int value) {
        System.out.print(value + " ");
    }

    public void newLine() {
        System.out.println();
    }

    @Override
    public void close() throws IOException {
        System.out.println("Finished");
    }
}
