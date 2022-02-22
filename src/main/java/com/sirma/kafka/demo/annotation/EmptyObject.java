package com.sirma.kafka.demo.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmptyObjectValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmptyObject {
  String message() default "Object has no data";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
