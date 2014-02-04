package exercise.cca.input.valid.impl.by.string;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InputValidatorTest {
    private static final String PATTERN = "pattern";
    private static final String LINE = "AAA 1000";
    private InputValidator inputValidator;

    @BeforeMethod
    public void setupTestResource() {
        inputValidator = new InputValidator();
    }

    @Test
    public void shouldAssertTrueForValidPatternTest() {
        inputValidator.setPattern(PATTERN);
        assertTrue(inputValidator.isValid(PATTERN));
    }

    @Test
    public void shouldAssertFalseForNotValidPatternTest() {
        inputValidator.setPattern(PATTERN);
        assertFalse(inputValidator.isValid(LINE));
    }
}
