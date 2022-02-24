package com.sirma.kafka.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sirma.kafka.demo.annotation.EmptyObject;
import com.sirma.kafka.demo.common.AppConstants;
import com.sirma.kafka.demo.common.ErrorMessages;
import com.sirma.kafka.demo.common.KafkaErrorMessages;
import com.sirma.kafka.demo.common.KafkaMessageJsonFieldConstants;
import com.sirma.kafka.demo.enums.EventType;
import com.sirma.kafka.demo.enums.TaskModelType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * This class represents the structure of the message, received by Task Center through Kafka
 */
@JsonDeserialize(using = KafkaMessageModelDeserializer.class)
public class KafkaMessageModel {

    @EmptyObject(message = KafkaErrorMessages.TASK_IS_REQUIRED)
    private JsonNode task;

    @NotNull(message = KafkaErrorMessages.EVENT_TYPE_IS_REQUIRED)
    private EventType eventType;

    @NotNull(message = KafkaErrorMessages.TASK_MODEL_TYPE_IS_REQUIRED)
    private TaskModelType taskModelType;

    @NotEmpty(message = KafkaErrorMessages.TENANT_ID_IS_REQUIRED)
    private String tenantId;

    @NotEmpty(message = KafkaErrorMessages.TENANT_URL_IS_REQUIRED)
    @URL(message = KafkaErrorMessages.TENANT_URL_IS_NOT_VALID)
    private String tenantUrl;

    @NotEmpty(message = KafkaErrorMessages.PROCESSOR_EMAIL_IS_REQUIRED)
    @Pattern(regexp = AppConstants.EMAIL_REGEX, message = ErrorMessages.EMAIL_IS_NOT_VALID)
    private String processorEmail;

    @NotEmpty(message = KafkaErrorMessages.PROCESSOR_DISPLAY_NAME_IS_REQUIRED)
    @Length(min = AppConstants.DISPLAY_NAME_MIN_LENGTH,
            message = KafkaErrorMessages.PROCESSOR_DISPLAY_NAME_MIN_LENGTH_IS_NOT_VALID)
    @Length(max = AppConstants.DISPLAY_NAME_MAX_LENGTH,
            message = KafkaErrorMessages.PROCESSOR_DISPLAY_NAME_MAX_LENGTH_IS_NOT_VALID)
    private String processorDisplayName;

    @NotEmpty(message = KafkaErrorMessages.RECIPIENTS_EMAIL_ARE_REQUIRED)
    private RecipientsEmail recipientsEmail;

    @JsonCreator KafkaMessageModel(
            @JsonProperty(value = KafkaMessageJsonFieldConstants.TASK, required = true, access = JsonProperty.Access.READ_WRITE)
                    JsonNode task,
            @JsonProperty(value = KafkaMessageJsonFieldConstants.EVENT_TYPE, required = true, access = JsonProperty.Access.READ_WRITE)
                    EventType eventType,
            @JsonProperty(value = KafkaMessageJsonFieldConstants.TASK_MODEL_TYPE, required = true, access = JsonProperty.Access.READ_WRITE)
                    TaskModelType taskModelType,
            @JsonProperty(value = KafkaMessageJsonFieldConstants.TENANT_ID, required = true, access = JsonProperty.Access.READ_WRITE)
                    String tenantId,
            @JsonProperty(value = KafkaMessageJsonFieldConstants.TENANT_URL, required = true, access = JsonProperty.Access.READ_WRITE)
                    String tenantUrl,
            @JsonProperty(value = KafkaMessageJsonFieldConstants.PROCESSOR_EMAIL, required = true, access = JsonProperty.Access.READ_WRITE)
                    String processorEmail,
            @JsonProperty(value = KafkaMessageJsonFieldConstants.PROCESSOR_DISPLAY_NAME, access = JsonProperty.Access.READ_WRITE)
                    String processorDisplayName,
            @JsonProperty(value = KafkaMessageJsonFieldConstants.RECIPIENTS_EMAIL, required = true, access = JsonProperty.Access.READ_WRITE)
                    RecipientsEmail recipientsEmail
    ) {
        this.task = task;
        this.eventType = eventType;
        this.taskModelType = taskModelType;
        this.tenantId = tenantId;
        this.tenantUrl = tenantUrl;
        this.processorEmail = processorEmail;
        this.processorDisplayName = processorDisplayName;
        this.recipientsEmail = recipientsEmail;
    }

    public JsonNode getTask() {
        return task;
    }

    public void setTask(ObjectNode task) {
        this.task = task;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getTenantUrl() {
        return tenantUrl;
    }

    public void setTenantUrl(String tenantUrl) {
        this.tenantUrl = tenantUrl;
    }

    public String getProcessorEmail() {
        return processorEmail;
    }

    public void setProcessorEmail(String processorEmail) {
        this.processorEmail = processorEmail;
    }

    public String getProcessorDisplayName() {
        return processorDisplayName;
    }

    public void setProcessorDisplayName(String processorDisplayName) {
        this.processorDisplayName = processorDisplayName;
    }

    public void setTask(JsonNode task) {
        this.task = task;
    }

    public TaskModelType getTaskModelType() {
        return taskModelType;
    }

    public void setTaskModelType(TaskModelType taskModelType) {
        this.taskModelType = taskModelType;
    }

    public RecipientsEmail getRecipientsEmail() {
        return recipientsEmail;
    }

    public void setRecipientsEmail(RecipientsEmail recipientsEmail) {
        this.recipientsEmail = recipientsEmail;
    }

    @Override public String toString() {
        return "KafkaMessageModel{" +
                "task=" + task +
                ", eventType=" + eventType +
                ", tenantId='" + tenantId + '\'' +
                ", tenantUrl='" + tenantUrl + '\'' +
                ", processorEmail='" + processorEmail + '\'' +
                ", processorDisplayName='" + processorDisplayName + '\'' +
                ", recipientsEmail=" + recipientsEmail +
                '}';
    }
}
