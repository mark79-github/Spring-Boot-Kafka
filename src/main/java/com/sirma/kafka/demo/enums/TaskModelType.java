package com.sirma.kafka.demo.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of TaskModel
 */
public enum TaskModelType {
    SPI("SPI"),
    API("API"),
    TCM("TCM");

    private final String value;

    TaskModelType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
