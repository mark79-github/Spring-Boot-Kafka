package com.sirma.kafka.demo.common;

public class ErrorMessages {

  public static final String DATA_IS_REQUIRED = "Data is required";
  public static final String EVENT_IS_REQUIRED = "Event is required";
  public static final String TENANT_ID_IS_REQUIRED = "TenantId is required";
  public static final String TENANT_URL_IS_REQUIRED = "TenantUrl is required";
  public static final String DISPLAY_NAME_IS_REQUIRED = "DisplayName is required";
  public static final String EMAILS_ARE_REQUIRED = "Emails are required";

  public static final String TENANT_URL_IS_NOT_VALID = "TenantUrl must be valid url";
  public static final String EMAIL_IS_NOT_VALID = "Email format is not valid";
  public static final String DISPLAY_NAME_LENGTH_IS_NOT_VALID =
      "Display name must be between "
          + AppConstants.DISPLAY_NAME_MIN_LENGTH
          + " and "
          + AppConstants.DISPLAY_NAME_MAX_LENGTH
          + " characters";

  private ErrorMessages() {}
}
