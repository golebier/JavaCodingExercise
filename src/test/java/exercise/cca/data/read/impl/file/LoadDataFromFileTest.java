package exercise.cca.data.read.impl.file;

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNull;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import exercise.cca.data.container.impl.map.DataContainerMap;
import exercise.cca.data.read.impl.reader.ReaderLoader;

public class LoadDataFromFileTest {
    private static final String CORRECT_CURRENCY = "USD";
    private static final String TEST_FILE_PATH = "src/test/resources/exercise/cca/data/read/impl/file/currency-vs-value-test-data.txt";
    private static final String WRONG_FILE_PATH = "notExistingFile";

    private LoadDataFromFile loader;
    private DataContainerMap data;
    private ReaderLoader reader;

    @BeforeMethod
    public void setupTestResource() {
        data = new DataContainerMap();
        reader = new ReaderLoader();
        reader.setData(data);
        loader = new LoadDataFromFile();
        loader.setReaderLoader(reader);
    }

    @Test
    public void shouldNotLoadDataIfPathIsNullTest() throws IOException {
        loader.load();
        assertNull(data.read(CORRECT_CURRENCY));
    }

    @Test
    public void shouldLoadNothingIfFileNotExistsTest() throws IOException {
        loader.setFilePath(WRONG_FILE_PATH);
        loader.load();
        assertNull(data.read(CORRECT_CURRENCY));
    }

    @Test
    public void shouldLoadDataWithoutExceptionTest() throws IOException {
        loader.setFilePath(TEST_FILE_PATH);
        loader.load();
        assertNotNull(data.read(CORRECT_CURRENCY));
    }
}
