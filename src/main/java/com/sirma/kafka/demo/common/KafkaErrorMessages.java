package com.sirma.kafka.demo.common;

public class KafkaErrorMessages {

    public static final String TASK_IS_REQUIRED = "Task is required";
    public static final String EVENT_TYPE_IS_REQUIRED = "EventType is required";
    public static final String TASK_MODEL_TYPE_IS_REQUIRED = "TaskModelType is required";
    public static final String TENANT_ID_IS_REQUIRED = "TenantId is required";
    public static final String TENANT_URL_IS_REQUIRED = "TenantUrl is required";
    public static final String PROCESSOR_DISPLAY_NAME_IS_REQUIRED = "DisplayName is required";
    public static final String RECIPIENTS_EMAIL_ARE_REQUIRED = "RecipientsEmail is required";
    public static final String PROCESSOR_EMAIL_IS_REQUIRED = "ProcessorEmail is required";

    public static final String EVENT_TYPE_INVALID_DATA = "Invalid value for enum type EventType";
    public static final String TASK_MODEL_TYPE_INVALID_DATA = "Invalid value for enum type TaskModelType";
    public static final String TENANT_URL_IS_NOT_VALID = "TenantUrl must be valid url";
    public static final String EMAIL_IS_NOT_VALID = "Email format is not valid";
    public static final String PROCESSOR_DISPLAY_NAME_MIN_LENGTH_IS_NOT_VALID =
            "Display name must be at least " + AppConstants.DISPLAY_NAME_MIN_LENGTH + " characters long.";
    public static final String PROCESSOR_DISPLAY_NAME_MAX_LENGTH_IS_NOT_VALID =
            "Display name must be a maximum of " + AppConstants.DISPLAY_NAME_MAX_LENGTH + " characters long.";

    private KafkaErrorMessages() {
    }
}
