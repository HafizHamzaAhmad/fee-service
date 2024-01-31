package org.rak.fee.unit.fee;

import java.util.Arrays;

public enum FeeCategory {
    GRADE("GRADE"),
    SCHOOL("SCHOOL"),
    STUDENT("STUDENT")
    ;

    private String value;

    FeeCategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isValid(String feeType) {
        return Arrays.stream(FeeCategory.values()).anyMatch(feeType1 -> feeType1.getValue().equals(feeType));
    }
}
