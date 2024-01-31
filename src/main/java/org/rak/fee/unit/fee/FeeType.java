package org.rak.fee.unit.fee;

import java.util.Arrays;

public enum FeeType {
    TUITION("TUITION"),
    ADMISSION("ADMISSION")
    ;

    private String value;

    FeeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isValid(String feeType) {
        return Arrays.stream(FeeType.values()).anyMatch(feeType1 -> feeType1.getValue().equals(feeType));
    }
}
