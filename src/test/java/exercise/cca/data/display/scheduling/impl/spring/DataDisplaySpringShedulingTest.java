package exercise.cca.data.display.scheduling.impl.spring;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import exercise.cca.data.container.impl.map.DataContainerMap;

@ContextConfiguration
public class DataDisplaySpringShedulingTest extends
        AbstractTestNGSpringContextTests {
    private static final int A_WAIT_TIME_VALUE = 61;
    private static final float NEGATIVE_VALUE = -100f;
    private static final float POSITIVE_VALUE = 100f;
    private static final float MULTIPLIER_1ST = 0.34f;
    private static final float MULTIPLIER_2ND = 0.12f;
    private static final String VALID_CURRENCY_1ST = "AAA";
    private static final String VALID_CURRENCY_2ND = "BBB";

    @Autowired
    private DataContainerMap data;

    @Autowired
    private DataContainerMap theExchangeRateData;

    @Autowired
    private CountDownLatch xmlCountDownLatch;

    @Test
    public void shouldDisplayDataInAMinutShedulTest()
            throws InterruptedException {
        prepareData();

        xmlCountDownLatch.await(A_WAIT_TIME_VALUE, TimeUnit.SECONDS);
        // TODO assert data display
    }

    @Test
    public void shouldDisplayDataInAMinutWithTheExchangeRateDataShedulTest()
            throws InterruptedException {
        prepareData();
        prepareTheExchangeRateData();

        xmlCountDownLatch.await(A_WAIT_TIME_VALUE, TimeUnit.SECONDS);
        // TODO assert data display
    }

    private void prepareData() {
        data.add(VALID_CURRENCY_1ST, NEGATIVE_VALUE);
        data.add(VALID_CURRENCY_2ND, POSITIVE_VALUE);
    }

    private void prepareTheExchangeRateData() {
        theExchangeRateData.add(VALID_CURRENCY_1ST, MULTIPLIER_1ST);
        theExchangeRateData.add(VALID_CURRENCY_2ND, MULTIPLIER_2ND);
    }
}