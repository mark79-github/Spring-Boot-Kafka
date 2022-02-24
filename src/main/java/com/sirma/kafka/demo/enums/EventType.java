package com.sirma.kafka.demo.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The event of the task
 */
public enum EventType {
    TASK_STATUS_UPDATE("TASK_STATUS_UPDATE"),

    TASK_STATUS_UPDATE_NEW("TASK_STATUS_UPDATE_NEW");

    private final String value;

    EventType(String value) {
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
