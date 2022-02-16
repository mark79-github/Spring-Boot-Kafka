package com.sirma.kafka.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.sirma.kafka.demo.common.AppConstants;
import com.sirma.kafka.demo.common.ErrorMessages;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class KafkaMessage {

  @JsonProperty
  @NotNull(message = ErrorMessages.DATA_IS_REQUIRED)
  private JsonNode data;

  @JsonProperty
  @NotEmpty(message = ErrorMessages.EVENT_IS_REQUIRED)
  private String event;

  @JsonProperty
  @NotEmpty(message = ErrorMessages.TENANT_ID_IS_REQUIRED)
  private String tenantId;

  @JsonProperty
  @URL(message = ErrorMessages.TENANT_URL_IS_NOT_VALID)
  @NotEmpty(message = ErrorMessages.TENANT_URL_IS_REQUIRED)
  private String tenantUrl;

  @JsonProperty
  @Length(
      min = AppConstants.DISPLAY_NAME_MIN_LENGTH,
      max = AppConstants.DISPLAY_NAME_MAX_LENGTH,
      message = ErrorMessages.DISPLAY_NAME_LENGTH_IS_NOT_VALID)
  @NotEmpty(message = ErrorMessages.DISPLAY_NAME_IS_REQUIRED)
  private String displayName;

  @JsonProperty
  @NotEmpty(message = ErrorMessages.EMAILS_ARE_REQUIRED)
  private List<@Email(message = ErrorMessages.EMAIL_IS_NOT_VALID) String> emails;

  private KafkaMessage() {}

  @Override
  public String toString() {
    return "KafkaMessage{"
        + "data="
        + data
        + ", event='"
        + event
        + '\''
        + ", tenantId='"
        + tenantId
        + '\''
        + ", tenantUrl='"
        + tenantUrl
        + '\''
        + ", displayName='"
        + displayName
        + '\''
        + ", emails="
        + emails
        + '}';
  }
}
