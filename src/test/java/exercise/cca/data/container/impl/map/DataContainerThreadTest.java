package exercise.cca.data.container.impl.map;

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNull;

import org.testng.annotations.Test;

public class DataContainerThreadTest {
	private static final float NEGATIVE_VALUE = -100f;
	private static final float POSITIVE_VALUE = 100f;
    private static final int TIME_OUT = 50000;
    private static final int INVOCATION_COUNT = 900;
    private static final int THREAD_POOL_SIZE = 300;
	private static final String VALID_CURRENCY_1ST = "AAA";
	private static final String VALID_CURRENCY_2ND = "BBB";
    private static final String DESCRIPTION = "Verification is possible deadlocking with a bigger data portions.";

	private static final DataContainerMap data = new DataContainerMap();

	@Test
	public void shouldAssertNullIfCurrecyAmountIsZero() {
		data.add(VALID_CURRENCY_1ST, POSITIVE_VALUE);
		data.add(VALID_CURRENCY_1ST, NEGATIVE_VALUE);

		assertNull(data.read(VALID_CURRENCY_1ST));
	}

	@Test(threadPoolSize = THREAD_POOL_SIZE, invocationCount = INVOCATION_COUNT, timeOut = TIME_OUT, description = DESCRIPTION)
	public void shouldAssertNotNullIfCurrencyValueIsNotZero() {
		data.add(VALID_CURRENCY_2ND, POSITIVE_VALUE);
		data.add(VALID_CURRENCY_2ND, POSITIVE_VALUE);
		data.add(VALID_CURRENCY_2ND, NEGATIVE_VALUE);

		assertNotNull(data.read(VALID_CURRENCY_2ND));
	}
}
