package exercise.cca.data.cli.main;

import java.io.IOException;

import org.testng.annotations.Test;

public class MainCliTest {
    @Test
    public void shouldRunFullTest() throws IOException {
        MainCli.main(null);
    }
}
