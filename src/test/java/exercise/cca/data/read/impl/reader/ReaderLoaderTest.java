package exercise.cca.data.read.impl.reader;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.io.IOException;
import java.io.StringReader;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import exercise.cca.data.container.impl.map.DataContainerMap;

public class ReaderLoaderTest {
    private static final String CORRECT_CURRENCY = "AAA";
    private static final String CORRECT_READER_STRING = CORRECT_CURRENCY
            + " 100";
    private static final String INCORRECT_CURENCY_IN_READER_STRING = "0AA 1000";
    private static final String INCORRECT_VALUE_IN_READER_STRING = CORRECT_CURRENCY
            + " AAA";
    private static final StringReader CORRECT_READER = new StringReader(
            CORRECT_READER_STRING);
    private static final StringReader INCORRECT_CURENCY_IN_READER = new StringReader(
            INCORRECT_CURENCY_IN_READER_STRING);
    private static final StringReader INCORRECT_VALUE_IN_READER = new StringReader(
            INCORRECT_VALUE_IN_READER_STRING);
    private static final DataContainerMap NULL_DATA_CONTAINER = null;

    private ReaderLoader reader;
    private DataContainerMap data;

    @BeforeMethod
    public void setupTestResource() {
        data = new DataContainerMap();
        reader = new ReaderLoader();
        reader.setData(data);
    }

    @Test
    public void shouldDoneNothingIfDataContainerIsNullTest() {
        reader.setData(NULL_DATA_CONTAINER);

        assertNull(data.listData().get(CORRECT_CURRENCY));
    }

    @Test
    public void shouldAddCurrencyAndValueIfThoseAreValidTest()
            throws IOException {
        reader.load(CORRECT_READER);

        assertNotNull(data.listData().get(CORRECT_CURRENCY));
    }

    @Test
    public void shouldAddNotNullDataPairsTest() throws IOException {
        reader.load(INCORRECT_CURENCY_IN_READER);

        assertNull(data.listData().get(CORRECT_CURRENCY));
    }

    @Test
    public void shouldDisplayErrorWhenIncorrectValueTest() throws IOException {
        reader.load(INCORRECT_VALUE_IN_READER);

        assertNull(data.listData().get(CORRECT_CURRENCY));
    }
}
