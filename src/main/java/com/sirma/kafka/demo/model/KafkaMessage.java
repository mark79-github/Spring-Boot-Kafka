package com.sirma.kafka.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sirma.kafka.demo.annotation.EmptyObject;
import com.sirma.kafka.demo.common.AppConstants;
import com.sirma.kafka.demo.common.ErrorMessages;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@JsonDeserialize(using = KafkaMessageDeserializer.class)
public class KafkaMessage {

  @NotNull(message = ErrorMessages.DATA_IS_REQUIRED)
  @EmptyObject(message = ErrorMessages.DATA_IS_REQUIRED)
  private JsonNode data;

  @URL(message = ErrorMessages.TENANT_URL_IS_NOT_VALID)
  @NotEmpty(message = ErrorMessages.TENANT_URL_IS_REQUIRED)
  private String tenantUrl;

  @Length(
      min = AppConstants.DISPLAY_NAME_MIN_LENGTH,
      message = ErrorMessages.DISPLAY_NAME_MIN_LENGTH_IS_NOT_VALID)
  @Length(
      max = AppConstants.DISPLAY_NAME_MAX_LENGTH,
      message = ErrorMessages.DISPLAY_NAME_MAX_LENGTH_IS_NOT_VALID)
  @NotEmpty(message = ErrorMessages.DISPLAY_NAME_IS_REQUIRED)
  private String displayName;

  @NotEmpty(message = ErrorMessages.EMAILS_ARE_REQUIRED)
  private List<
          @Pattern(regexp = AppConstants.EMAIL_REGEX, message = ErrorMessages.EMAIL_IS_NOT_VALID)
          String>
      emails;

  public KafkaMessage(
      @JsonProperty(required = true) JsonNode data,
      @JsonProperty(required = true) String tenantUrl,
      @JsonProperty(required = true) String displayName,
      @JsonProperty(required = true) List<String> emails) {
    this.data = data;
    this.tenantUrl = tenantUrl;
    this.displayName = displayName;
    this.emails = emails;
  }

  public JsonNode getData() {
    return data;
  }

  public void setData(JsonNode data) {
    this.data = data;
  }

  public String getTenantUrl() {
    return tenantUrl;
  }

  public void setTenantUrl(String tenantUrl) {
    this.tenantUrl = tenantUrl;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public List<String> getEmails() {
    return emails;
  }

  public void setEmails(List<String> emails) {
    this.emails = emails;
  }
}
