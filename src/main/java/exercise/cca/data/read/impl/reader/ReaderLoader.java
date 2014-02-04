package exercise.cca.data.read.impl.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.regex.Pattern;

import exercise.cca.data.container.impl.map.DataContainerMap;
import exercise.cca.input.valid.impl.by.string.InputValidator;

public class ReaderLoader {
    private static final String INCORRECT_CURRENCY_VALUE = "Err: currency value is incorrect (";
    private static final String INCORRECT_CURRENCY = "Err: currency is incorrect (";
    private static final String CLOSING_STRING = ")!";
    private static final int SUBSTRING_END_INDEX = 3;
    private static final int SUBSTRING_BEG_INDEX = 0;
    private static final int CORRECT_PAIRS_SIZE = 2;
    private static final String SPACE_SEPARATOR_STRING = " ";
    private static final String CURRENCY_PATTERN_STRING = "\\S{3}";
    private static final Pattern PATTERN = Pattern
            .compile(CURRENCY_PATTERN_STRING);

    private DataContainerMap data;
    private InputValidator inputValidator;

    public void load(final Reader in) throws IOException {
        if (null == data) {
            return;
        }

        final BufferedReader br = new BufferedReader(in);
        String line = br.readLine();
        while (null != line && shouldReadBeContinued(line)) {
            prepareData(line);
            line = br.readLine();
        }
        // finally & cca exception
        br.close();
    }

    // hm
    private boolean shouldReadBeContinued(final String line) {
        if (null != inputValidator && inputValidator.isValid(line)) {
            return false;
        }
        return true;
    }

    private void prepareData(final String pair) {
        final String[] parts = pair.split(SPACE_SEPARATOR_STRING);
        if (CORRECT_PAIRS_SIZE == parts.length) {
            final String currency = prepareCurrecy(parts[0]);
            final Float value = prepareValue(parts[1]);
            if (null != currency && null != value) {
                data.add(currency, value);
            }
        }
    }

    // cca exception
    private String prepareCurrecy(final String currency) {
        return prepareCurrencyWithValidation(currency.substring(
                SUBSTRING_BEG_INDEX, SUBSTRING_END_INDEX).toUpperCase());
    }

    // cca exception
    private String prepareCurrencyWithValidation(final String currency) {
        if (PATTERN.matcher(currency).matches()) {
            return currency;
        }
        System.err.println(INCORRECT_CURRENCY + currency + CLOSING_STRING);
        return null;
    }

    private Float prepareValue(final String value) {
        try {
            return Float.parseFloat(value);
        } catch (NumberFormatException e) {
            System.err.println(INCORRECT_CURRENCY_VALUE + e + CLOSING_STRING);
        }
        return null;
    }

    public void setData(DataContainerMap data) {
        this.data = data;
    }

    public void setInputValidator(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }
}
