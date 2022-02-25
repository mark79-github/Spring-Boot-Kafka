package com.sirma.kafka.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sirma.kafka.demo.common.AppConstants;
import com.sirma.kafka.demo.common.KafkaErrorMessages;
import com.sirma.kafka.demo.common.KafkaMessageJsonFieldConstants;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class RecipientModel {

  @NotNull(message = KafkaErrorMessages.DISPLAY_NAME_IS_REQUIRED)
  private String displayName;

  @Pattern(regexp = AppConstants.EMAIL_REGEX, message = KafkaErrorMessages.EMAIL_IS_NOT_VALID)
  private String email;

  @JsonCreator
  public RecipientModel(
      @JsonProperty(
              value = KafkaMessageJsonFieldConstants.DISPLAY_NAME,
              required = true,
              access = JsonProperty.Access.READ_WRITE)
          String displayName,
      @JsonProperty(
              value = KafkaMessageJsonFieldConstants.EMAIL,
              required = true,
              access = JsonProperty.Access.READ_WRITE)
          String email) {
    this.displayName = displayName;
    this.email = email;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
