package com.sirma.kafka.demo.model;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class KafkaMessage {
  @Expose
  @NotEmpty(message = "TenantId must not be empty")
  private String tenantId;

  @Expose
  @Length(min = 5, message = "Tenant URL  is 5")
  private String tenantUrl;

  @Expose
  @NotNull(message = "User must not be null")
  private User user;

  private KafkaMessage() {}

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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "KafkaMessage{" +
            "tenantId='" + tenantId + '\'' +
            ", tenantUrl='" + tenantUrl + '\'' +
            ", user=" + user +
            '}';
  }
}
