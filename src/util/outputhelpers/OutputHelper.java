package util.outputhelpers;

import java.io.Closeable;

public interface OutputHelper extends Closeable {
    void write(int value);
    void newLine();
}
