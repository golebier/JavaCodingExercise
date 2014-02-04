package exercise.cca.data.read.impl.reader;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.StringReader;

import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import exercise.cca.data.container.impl.map.DataContainerMap;
import exercise.cca.input.valid.impl.by.string.InputValidator;

public class ReaderLoaderWithInputValidatorInfluenceTest {
    private static final int CORRECT_WITHOUT_BREAK = 4;
    private static final int CORRECT_WITH_BREAK = 2;
    private static final boolean BREAK = true;
    private static final boolean NO_BREAK = false;
    private static final String CORRECT_CURRENCY = "AAA";
    private static final String CORRECT_READER_STRING = CORRECT_CURRENCY
            + " 100";

    private ReaderLoader reader;
    private DataContainerMap data;
    private InputValidator inputValidator;

    @BeforeMethod
    public void setupTestResource() {
        data = Mockito.mock(DataContainerMap.class);
        inputValidator = Mockito.mock(InputValidator.class);
        reader = new ReaderLoader();
        reader.setData(data);
        reader.setInputValidator(inputValidator);
    }

    @Test
    public void shouldLoadDataWithoutBreakTest() throws IOException {
        when(inputValidator.isValid(anyString())).thenReturn(NO_BREAK);

        reader.load(new StringReader(CORRECT_READER_STRING));
        reader.load(new StringReader(CORRECT_READER_STRING));
        reader.load(new StringReader(CORRECT_READER_STRING));
        reader.load(new StringReader(CORRECT_READER_STRING));

        verify(data, times(CORRECT_WITHOUT_BREAK)).add(anyString(),
                any(Float.class));
    }

    @Test
    public void shouldLoadOnlyHaftDataWithBreakTest() throws IOException {
        when(inputValidator.isValid(anyString())).thenReturn(NO_BREAK)
                .thenReturn(NO_BREAK).thenReturn(BREAK);

        reader.load(new StringReader(CORRECT_READER_STRING));
        reader.load(new StringReader(CORRECT_READER_STRING));
        reader.load(new StringReader(CORRECT_READER_STRING));
        reader.load(new StringReader(CORRECT_READER_STRING));

        verify(data, times(CORRECT_WITH_BREAK)).add(anyString(),
                any(Float.class));
    }
}
