package exercise.cca.input.valid.impl.by.string;

public class InputValidator {
    private String pattern;

    public boolean isValid(final String checkIt) {
        return checkIt.contains(pattern);
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}
