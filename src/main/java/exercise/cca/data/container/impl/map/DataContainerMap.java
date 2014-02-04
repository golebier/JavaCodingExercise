package exercise.cca.data.container.impl.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DataContainerMap {
    private static final Float NOT_ACCEPTED_VALUE = 0.0f;
    /** data base - [???,*] pairs. */
    private Map<String, Float> data;

    public DataContainerMap() {
        data = Collections.synchronizedMap(new HashMap<String, Float>());
    }

    /**
     * add pairs to data container assumption: currency is valid.
     */
    public void add(final String currency, final Float amount) {
        synchronized (data) {
            final Float prevAmount = data.get(currency);
            Float sum = amount;
            if (null != prevAmount) {
                sum += prevAmount;
            }

            if (sum.equals(NOT_ACCEPTED_VALUE) && null != prevAmount) {
                data.remove(currency);
            } else {
                data.put(currency, sum);
            }
        }
    }

    public Float read(final String currency) {
        return data.get(currency);
    }

    public Map<String, Float> listData() {
        return new HashMap<String, Float>(data);
    }
}
