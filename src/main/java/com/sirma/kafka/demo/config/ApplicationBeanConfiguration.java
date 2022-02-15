package com.sirma.kafka.demo.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sirma.kafka.demo.utils.ValidationUtil;
import com.sirma.kafka.demo.utils.ValidationUtilImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

  @Bean
  public ValidationUtil validationUtil() {
    return new ValidationUtilImpl();
  }

  //      @Bean
  //      public Gson gson() {
  //          return new GsonBuilder()
  //                  .excludeFieldsWithoutExposeAnnotation()
  //                  .setPrettyPrinting()
  //                  .serializeNulls()
  //                  .create();
  //      }

  @Bean
  public ObjectMapper objectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, true);
    return objectMapper;
  }
}
