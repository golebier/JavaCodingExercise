package exercise.cca.data.read.impl.file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import exercise.cca.data.read.impl.reader.ReaderLoader;

public class LoadDataFromFile {
    private String filePath;
    private ReaderLoader readerLoader;

    public void load() throws IOException {
        if (null != filePath) {
            final File file = new File(filePath);
            if (null != file && file.exists()) {
                load(file);
            }
        }
    }

    private void load(final File file) throws IOException {
        readerLoader.load(new FileReader(file));
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setReaderLoader(ReaderLoader readerLoader) {
        this.readerLoader = readerLoader;
    }
}
