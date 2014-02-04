package exercise.cca.data.read.impl.system.in;

import java.io.IOException;
import java.io.InputStreamReader;

import exercise.cca.data.read.impl.reader.ReaderLoader;

// it is not nice, inject correct bean?
public class SystemIn {
    private ReaderLoader readerLoader;

    public void load() throws IOException {
        readerLoader.load(new InputStreamReader(System.in));
    }

    public void setReaderLoader(ReaderLoader readerLoader) {
        this.readerLoader = readerLoader;
    }
}
