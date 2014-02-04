package exercise.cca.data.display.impl.cmd;

import java.util.Map.Entry;

import exercise.cca.data.container.impl.map.DataContainerMap;

// any output stream
public class DispalyDataOnCmd {
    private static final String CURRENCY_MULTIPLIED_BY = "USD ";
    private static final String OPEN_STRING = " (";
    private static final String CLOSE_STRING = ")";
    private static final String SPACE_STRING = " ";

    private DataContainerMap data;
    private DataContainerMap theExchangeRateData;

    public void displayData() {
        if (null != data) {
            for (final Entry<String, Float> key : data.listData().entrySet()) {
                final StringBuilder outputString = new StringBuilder();
                outputString.append(key.getKey()).append(SPACE_STRING)
                        .append(key.getValue());
                prepareTheExchangeRate(key, outputString);
                // thought out
                System.out.println(outputString.toString());
            }
            // thought out
            System.out.println();
        }
    }

    private void prepareTheExchangeRate(final Entry<String, Float> key,
            final StringBuilder outputString) {
        if (null != theExchangeRateData
                && null != theExchangeRateData.listData()) {
            final Float value = theExchangeRateData.listData()
                    .get(key.getKey());
            if (null != value) {
                outputString.append(OPEN_STRING).append(CURRENCY_MULTIPLIED_BY)
                        .append(key.getValue() * value).append(CLOSE_STRING);
            }
        }
    }

    public void setData(DataContainerMap data) {
        this.data = data;
    }

    public void setTheExchangeRateData(DataContainerMap theExchangeRateData) {
        this.theExchangeRateData = theExchangeRateData;
    }
}
