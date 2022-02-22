package com.sirma.kafka.demo.annotation;

import com.fasterxml.jackson.databind.JsonNode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmptyObjectValidator implements ConstraintValidator<EmptyObject, JsonNode> {

  @Override
  public boolean isValid(JsonNode object, ConstraintValidatorContext cxt) {
    return object != null && object.isObject() && object.size() > 0;
  }
}
