package generators.impl.librarian;

import generators.Generator;
import util.inputhelpers.StringFileInputHelper;

public class LibrarianGenerator implements Generator {
    private int currentState;
    private String text;
    private final int MODULE = 256;

    public LibrarianGenerator(String filename) {
        StringFileInputHelper fileInputHelper = new StringFileInputHelper(filename);
        currentState = 0;
        text = fileInputHelper.readFromFile();
    }

    @Override
    public int nextValue() {
        currentState %= text.length() - 1;
        return (int)text.charAt(currentState++) % MODULE;
    }
}

