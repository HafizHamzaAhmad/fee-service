package org.rak.fee.unit.fee;

import java.util.Arrays;

public enum FeeFrequency {
    MONTHLY("MONTHLY"),
    ANNUAL("ANNUAL"),
    ONE_TIME("ONE_TIME")
    ;

    private String value;

    FeeFrequency(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isValid(String feeFrequency) {
        return Arrays.stream(FeeFrequency.values()).anyMatch(feeFrequency1 -> feeFrequency1.getValue().equals(feeFrequency));
    }
}
