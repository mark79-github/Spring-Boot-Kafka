package com.sirma.kafka.demo.model;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class User {
  @Expose
  @NotEmpty(message = "UserId must not be empty")
  private Long userId;

  @Expose
  @Length(min = 5, message = "First Name must be at least 5 characters long")
  private String firstName;

  @Expose
  @Length(min = 5, message = "Last Name must be at least 5 characters long")
  private String lastName;

  @Expose
  @Email(message = "Email format is not valid")
  private String email;

  private User() {}

  public long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "User{"
        + "userId="
        + userId
        + ", firstName='"
        + firstName
        + '\''
        + ", lastName='"
        + lastName
        + '\''
        + ", email='"
        + email
        + '\''
        + '}';
  }
}
